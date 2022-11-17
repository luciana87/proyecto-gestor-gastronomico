package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.PedidoAlProveedorDTO;
import org.ada.gestorgastronomico.service.PedidoAlProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoAlProveedorController {

    private final PedidoAlProveedorService pedidoAlProveedorService;

    public PedidoAlProveedorController(PedidoAlProveedorService pedidoAlProveedorService) {
        this.pedidoAlProveedorService = pedidoAlProveedorService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody PedidoAlProveedorDTO pedidoAlProveedorDTO){
        try {
            PedidoAlProveedorDTO createdPedidoAlProveedorDTO = pedidoAlProveedorService.create(pedidoAlProveedorDTO);
            return new ResponseEntity(createdPedidoAlProveedorDTO.getNumero(), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }
}
