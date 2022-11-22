package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.PedidoAlProveedorDTO;
import org.ada.gestorgastronomico.service.PedidoAlProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/proveedores/{proveedorId}/pedidos")
public class PedidoAlProveedorController {

    private final PedidoAlProveedorService pedidoAlProveedorService;

    public PedidoAlProveedorController(PedidoAlProveedorService pedidoAlProveedorService) {
        this.pedidoAlProveedorService = pedidoAlProveedorService;
    }


    @PostMapping
    public ResponseEntity create (@PathVariable String proveedorId, @RequestBody List<PedidoAlProveedorDTO> pedidosAlProveedorDTO){
        try {
            pedidoAlProveedorService.create2(proveedorId, pedidosAlProveedorDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/{cuitProveedor}")
    public ResponseEntity retrieveByProveedor (@PathVariable String cuitProveedor) {
        return new ResponseEntity(pedidoAlProveedorService.retrieveByProveedor(cuitProveedor), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity retrieve () {
        return new ResponseEntity(pedidoAlProveedorService.retrieveAll(), HttpStatus.OK);
    }


}
