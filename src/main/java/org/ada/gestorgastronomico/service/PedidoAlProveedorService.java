package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ItemPedidoDTO;
import org.ada.gestorgastronomico.dto.PedidoAlProveedorDTO;
import org.ada.gestorgastronomico.entity.ItemPedido;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.ada.gestorgastronomico.repository.PedidoAlProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoAlProveedorService {

    private final PedidoAlProveedorRepository pedidoAlProveedorRepository;
    private final ProveedorService proveedorService;
    private final ItemPedidoService itemPedidoService;

    public PedidoAlProveedorService(PedidoAlProveedorRepository pedidoAlProveedorRepository, ProveedorService proveedorService, ItemPedidoService itemPedidoService) {
        this.pedidoAlProveedorRepository = pedidoAlProveedorRepository;
        this.proveedorService = proveedorService;
        this.itemPedidoService = itemPedidoService;
    }

   /* public void create(String proveedorId, List<PedidoAlProveedorDTO> pedidosAlProveedorDTO) throws Exception {
        Optional<Proveedor> proveedor = proveedorService.findById(proveedorId);
        if (proveedor.isEmpty()){   //Chequeo si me devolvió un proveedor vacío
            throw new Exception ("Proveedor no encontrado");
        }

        List<PedidoAlProveedor> pedidos = pedidosAlProveedorDTO.stream()
                .map(pedidoAlProveedorDTO -> mapToEntity(pedidoAlProveedorDTO, proveedor.get()))
                .collect(Collectors.toList());

        pedidoAlProveedorRepository.saveAll(pedidos);
    }*/

    // Método create para que cree un pedido con su lista de ítems.
    public void create2(String proveedorId, List<PedidoAlProveedorDTO> pedidosAlProveedorDTO) throws Exception {
        Optional<Proveedor> proveedor = proveedorService.findById(proveedorId); //Obtengo el proveedor con el id que recibí por la URL
        if (proveedor.isEmpty()){   //Verifico si me devolvió un proveedor vacío
            throw new Exception ("Proveedor no encontrado");
        }

        //Uso un foreach y no un stream porque necesito realizar más acciones por cada elemento de la lista de pedidos
        for (PedidoAlProveedorDTO pedidoAlProveedorDTO: pedidosAlProveedorDTO) {
            PedidoAlProveedor pedidoAlProveedor = mapToEntity(pedidoAlProveedorDTO, proveedor.get()); //Mapeo cada pedidoDTO a Entidad, y le envío el proveedor para agregarlo
            pedidoAlProveedorRepository.save(pedidoAlProveedor); //Guardo cada pedido de la lista de pedidos
            itemPedidoService.create(pedidoAlProveedorDTO.getItems(),pedidoAlProveedor); //Creo la lista de ítems de cada pedido con la información del body (la lista de ítems, y elpedido guardado)
            double montoCalculado = calcularMontoTotal (pedidoAlProveedor.getItems()); //Calculo el monto total
            pedidoAlProveedor.setMontoTotal(montoCalculado); //Lo setteo a la entidad o al DTO? El método debería retornar la lista de pedidos?
        }

    }

    public List<PedidoAlProveedorDTO> retrieveByProveedor(String cuitProveedor) {  //Retorna todos los pedidos de un proveedor específico según el campo cuit_proveedor de la tabla Pedidos (FK)

        List<PedidoAlProveedor> pedidosObtenidos = pedidoAlProveedorRepository.findByCuitProveedor(cuitProveedor);
        return mapToDTOS(pedidosObtenidos);
    }

    public List<PedidoAlProveedorDTO> retrieveAll() {
        List<PedidoAlProveedor> pedidosObtenidos = pedidoAlProveedorRepository.findAll();
        return mapToDTOS(pedidosObtenidos);
    }
    private PedidoAlProveedorDTO mapToDTO(PedidoAlProveedor pedidoAlProveedor) {
        PedidoAlProveedorDTO pedidoAlProveedorDTO = new PedidoAlProveedorDTO(pedidoAlProveedor.getFecha().toString(),
                pedidoAlProveedor.getMontoTotal(), pedidoAlProveedor.getEstado());

        pedidoAlProveedorDTO.setNumero(pedidoAlProveedor.getNumero());

        return pedidoAlProveedorDTO;
    }
    private List<PedidoAlProveedorDTO> mapToDTOS(List<PedidoAlProveedor> pedidos) {
        return pedidos.stream().map(pedidoAlProveedor -> mapToDTO(pedidoAlProveedor)).collect(Collectors.toList());
    }

    private PedidoAlProveedor mapToEntity(PedidoAlProveedorDTO pedidoAlProveedorDTO, Proveedor proveedor) {
        PedidoAlProveedor pedidoAlProveedor = new PedidoAlProveedor(pedidoAlProveedorDTO.getEstado(), proveedor); //La lista de ítems está inicializada en el constructor, y el montoTotal se inicializa por defecto

        return pedidoAlProveedor;
    }

    private double calcularMontoTotal(List<ItemPedido> items) { // Este método va en este PedidoAlProveedorService o en la entidad PedidoAlProveedor?
        double montoCalculado = 0;
        for (ItemPedido item : items) {
            montoCalculado+= item.getPrecio_unitario();
        }

        return  montoCalculado;
    }

    public List<PedidoAlProveedorDTO> mapToDTOS(List<PedidoAlProveedor> pedidos) {
        return pedidos.stream().map(pedidoAlProveedor -> mapToDTO(pedidoAlProveedor)).collect(Collectors.toList());
    }

    private PedidoAlProveedorDTO mapToDTO(PedidoAlProveedor pedidoAlProveedor) {
        PedidoAlProveedorDTO pedidoAlProveedorDTO = new PedidoAlProveedorDTO(pedidoAlProveedor.getFecha().toString(),
                pedidoAlProveedor.getMontoTotal(), pedidoAlProveedor.getEstado());

        pedidoAlProveedorDTO.setNumero(pedidoAlProveedor.getNumero());

        return pedidoAlProveedorDTO;
    }
}
