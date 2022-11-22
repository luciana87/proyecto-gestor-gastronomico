package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.ProductoDTO;
import org.ada.gestorgastronomico.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public ResponseEntity retrieve() {

        return new ResponseEntity(productoService.retrieveAll(), HttpStatus.OK);
    }


    @GetMapping("/{productoId}")
    public ResponseEntity retrieveById(@PathVariable Integer productoId) {
        try {

            ProductoDTO productoDTO = productoService.retrieveById(productoId);
            return new ResponseEntity(productoDTO, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
