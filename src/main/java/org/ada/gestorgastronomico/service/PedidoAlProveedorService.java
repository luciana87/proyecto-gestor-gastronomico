package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.PedidoAlProveedorDTO;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.ada.gestorgastronomico.repository.PedidoAlProveedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoAlProveedorService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final PedidoAlProveedorRepository pedidoAlProveedorRepository;
    private final ProveedorService proveedorService;

    public PedidoAlProveedorService(PedidoAlProveedorRepository pedidoAlProveedorRepository, ProveedorService proveedorService) {
        this.pedidoAlProveedorRepository = pedidoAlProveedorRepository;
        this.proveedorService = proveedorService;
    }

    public PedidoAlProveedorDTO create(PedidoAlProveedorDTO pedidoAlProveedorDTO) throws Exception { //Cuando cargo un pedido y le voy a asociar un proveedor
        PedidoAlProveedor pedidoAlProveedor = mapToEntity(pedidoAlProveedorDTO);//Mapeo el pedidoDTO
        pedidoAlProveedorRepository.save(pedidoAlProveedor);//Guardo la entidad en la DB

        return pedidoAlProveedorDTO; //La retorno
    }
    public void createList(List<PedidoAlProveedorDTO> pedidoAlProveedorDTOS, Proveedor proveedor){ //Cuando creo un proveedor y le cargo una lista de pedidos
        List<PedidoAlProveedor> pedidos = pedidoAlProveedorDTOS.stream()
                .map(pedidoAlProveedorDTO -> mapToEntity(pedidoAlProveedorDTO, proveedor))
                .collect(Collectors.toList());

        pedidoAlProveedorRepository.saveAll(pedidos);
    }

    private PedidoAlProveedor mapToEntity(PedidoAlProveedorDTO pedidoAlProveedorDTO, Proveedor proveedor) {
        PedidoAlProveedor pedidoAlProveedor = new PedidoAlProveedor(LocalDate.parse(pedidoAlProveedorDTO.getFecha(), DATE_TIME_FORMATTER),
                pedidoAlProveedorDTO.getMontoTotal(), pedidoAlProveedorDTO.getEstado(), proveedor);

        return pedidoAlProveedor;
    }
    private PedidoAlProveedor mapToEntity(PedidoAlProveedorDTO pedidoAlProveedorDTO) throws Exception {//Sin proveedor por parametro (sobrecarga de metodo)
        PedidoAlProveedor pedidoAlProveedor = new PedidoAlProveedor(LocalDate.parse(pedidoAlProveedorDTO.getFecha(), DATE_TIME_FORMATTER),
                pedidoAlProveedorDTO.getMontoTotal(), pedidoAlProveedorDTO.getEstado());

        //Le tengo que settear el valor del id del proveeedor (cuit), asociarlo con un proveedor
        Optional<Proveedor> proveedor = proveedorService.findById(pedidoAlProveedorDTO.getProveedorCuit());
        if (proveedor.isEmpty()){
            throw new Exception ("Proveedor no encontrado");
        }
        pedidoAlProveedor.setProveedor(proveedor.get());

        return pedidoAlProveedor;
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
