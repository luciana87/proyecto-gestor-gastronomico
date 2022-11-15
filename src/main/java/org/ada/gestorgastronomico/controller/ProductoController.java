package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.ProductoDTO;
import org.ada.gestorgastronomico.dto.ProveedorDTO;
import org.ada.gestorgastronomico.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ProductoDTO productoDTO){
        ProductoDTO createdProductoDTO = productoService.create(productoDTO);

        return new ResponseEntity(productoDTO.getCodigo(), HttpStatus.CREATED);
    }
}
