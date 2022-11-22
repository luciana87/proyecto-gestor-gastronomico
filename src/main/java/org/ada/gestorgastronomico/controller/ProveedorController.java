package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.ProveedorDTO;
import org.ada.gestorgastronomico.service.ProveedorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @PostMapping
    public ResponseEntity create (@RequestBody ProveedorDTO proveedorDTO){
        try {
            ProveedorDTO createdProveedorDTO = proveedorService.create(proveedorDTO);
            return new ResponseEntity(proveedorDTO.getCuit(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }


    @GetMapping
    public ResponseEntity retrieve(){
        return new ResponseEntity(proveedorService.retrieveAll(),HttpStatus.OK);
    }


    @GetMapping("/{proveedorId}")
    public ResponseEntity retrieveById (@PathVariable String proveedorId) {
        try {
            ProveedorDTO proveedorDTO = proveedorService.retrieveById(proveedorId);
            return new ResponseEntity(proveedorDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}