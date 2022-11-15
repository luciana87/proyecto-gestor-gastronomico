package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.ProductoDTO;
import org.ada.gestorgastronomico.entity.Producto;
import org.ada.gestorgastronomico.repository.ProductoRepository;
import org.springframework.stereotype.Service;

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

    private Producto mapToEntity(ProductoDTO productoDTO) {

        Producto producto = new Producto(productoDTO.getCodigo(),
                productoDTO.getNombre(), productoDTO.getPrecio());

        return producto;
    }
}
