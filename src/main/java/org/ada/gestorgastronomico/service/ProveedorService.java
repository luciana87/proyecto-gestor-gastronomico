package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ProveedorDTO;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.ada.gestorgastronomico.repository.ProveedorRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;
    private final PedidoAlProveedorService pedidoAlProveedorService;

    public ProveedorService(ProveedorRepository proveedorRepository, PedidoAlProveedorService pedidoAlProveedorService) {
        this.proveedorRepository = proveedorRepository;
        this.pedidoAlProveedorService = pedidoAlProveedorService;
    }

    public ProveedorDTO create(ProveedorDTO proveedorDTO){
        Proveedor proveedor = mapToEntity(proveedorDTO);
        proveedor = proveedorRepository.save(proveedor);

        if (!CollectionUtils.isEmpty(proveedorDTO.getPedidosDTO())){
            pedidoAlProveedorService.createList(proveedorDTO.getPedidosDTO(), proveedor);
        }

        return proveedorDTO;
    }

    public List<ProveedorDTO> retrieveAll(){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores.stream().map(person -> mapToDTO(person)).collect(Collectors.toList());
    }

    public Optional<Proveedor> findById(String cuitProveedor) {
        return proveedorRepository.findById(cuitProveedor);
    }

    public ProveedorDTO retrieveById(String cuitProveedor) throws Exception {
        Optional<Proveedor> proveedor = findById(cuitProveedor);
        if (proveedor.isEmpty()){
            throw new Exception ("Proveedor no encontrado");
        }
        return mapToDTO(proveedor.get());
    }


    private ProveedorDTO mapToDTO(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO(proveedor.getCuit(),
                proveedor.getNombre(), proveedor.getEmail(), proveedor.getTelefono(),
                proveedor.getDireccion(), pedidoAlProveedorService.mapToDTOS(proveedor.getPedidos())); //TODO: campo como nulo, modificarlo

        return proveedorDTO;
    }


    private Proveedor mapToEntity(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor(proveedorDTO.getCuit(),
                proveedorDTO.getNombre(), proveedorDTO.getEmail(),
                proveedorDTO.getTelefono(), proveedorDTO.getDireccion());

        return proveedor;
    }
}
