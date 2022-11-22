package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ProductoDTO;
import org.ada.gestorgastronomico.entity.Producto;
import org.ada.gestorgastronomico.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public ProductoDTO create(ProductoDTO productoDTO){
        Producto producto = mapToEntity(productoDTO);
        producto = productoRepository.save(producto);

        return productoDTO;
    }

    public List<ProductoDTO> retrieveAll() {

        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(producto -> mapToDTO(producto)).collect(Collectors.toList());
    }
    public ProductoDTO retrieveById(Integer productoId) throws Exception {
       Optional<Producto> producto = productoRepository.findById(productoId);
       if (producto.isEmpty()){
           throw new Exception("Persona no encontrada");
       }
       return mapToDTO(producto.get());
    }

    private Producto mapToEntity(ProductoDTO productoDTO) {

        Producto producto = new Producto(productoDTO.getCodigo(),
                productoDTO.getNombre(), productoDTO.getPrecio());

        return producto;
    }

    private ProductoDTO mapToDTO(Producto producto) {

        ProductoDTO productoDTO = new ProductoDTO(producto.getCodigo(),
                producto.getNombre(), producto.getPrecio());

        return productoDTO;
    }


}
