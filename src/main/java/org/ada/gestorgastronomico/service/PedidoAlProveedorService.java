package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.PedidoAlProveedorDTO;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.ada.gestorgastronomico.repository.PedidoAlProveedorRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoAlProveedorService {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final PedidoAlProveedorRepository pedidoAlProveedorRepository;

    public PedidoAlProveedorService(PedidoAlProveedorRepository pedidoAlProveedorRepository) {
        this.pedidoAlProveedorRepository = pedidoAlProveedorRepository;
    }

    public void create(List<PedidoAlProveedorDTO> pedidoAlProveedorDTOS, Proveedor proveedor){
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
