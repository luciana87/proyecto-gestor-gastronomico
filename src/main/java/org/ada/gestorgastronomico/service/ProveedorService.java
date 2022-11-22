package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ProveedorDTO;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.ada.gestorgastronomico.repository.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorService {
    private final ProveedorRepository proveedorRepository;
    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    public ProveedorDTO create(ProveedorDTO proveedorDTO) throws Exception {

        checkForExistingProveedor(proveedorDTO.getCuit());

        Proveedor proveedor = mapToEntity(proveedorDTO);
        proveedor = proveedorRepository.save(proveedor);

        return proveedorDTO;
    }

    public List<ProveedorDTO> retrieveAll(){
        List<Proveedor> proveedores = proveedorRepository.findAll();
        return proveedores.stream().map(proveedor -> mapToDTO(proveedor)).collect(Collectors.toList());
    }

    public ProveedorDTO retrieveById(String proveedorId) throws Exception {
        Optional<Proveedor> proveedor = proveedorRepository.findById(proveedorId);
        if (proveedor.isEmpty()){
            throw new Exception("Persona no encontrada");
        }
        return mapToDTO(proveedor.get());
    }

    public Optional<Proveedor> findById(String cuitProveedor) {
        return proveedorRepository.findById(cuitProveedor);
    }

    private ProveedorDTO mapToDTO(Proveedor proveedor) {
        ProveedorDTO proveedorDTO = new ProveedorDTO(proveedor.getCuit(),
                proveedor.getNombre(), proveedor.getEmail(), proveedor.getTelefono(),
                proveedor.getDireccion());

        return proveedorDTO;
    }


    private Proveedor mapToEntity(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor(proveedorDTO.getCuit(),
                proveedorDTO.getNombre(), proveedorDTO.getEmail(),
                proveedorDTO.getTelefono(), proveedorDTO.getDireccion());

        return proveedor;
    }
    private void checkForExistingProveedor(String cuitProveedor) throws Exception {
        if (proveedorRepository.existsById(cuitProveedor)) {
            throw new Exception("El proveedor que busca no existe"); //TODO: crear excepciones
        }
    }
}
