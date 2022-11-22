package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.MateriaPrimaDTO;
import org.ada.gestorgastronomico.service.MateriaPrimaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/materias-primas")
public class MateriaPrimaController {

    private final MateriaPrimaService materiaPrimaService;

    public MateriaPrimaController(MateriaPrimaService materiaPrimaService) {
        this.materiaPrimaService = materiaPrimaService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody MateriaPrimaDTO materiaPrimaDTO){
        MateriaPrimaDTO createdMateriaPrimaDTO = materiaPrimaService.create(materiaPrimaDTO);

        return new ResponseEntity<>(createdMateriaPrimaDTO.getId(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity retrieve(){

        return new ResponseEntity(materiaPrimaService.retrieveAll(),HttpStatus.OK);
    }
    @GetMapping("/{materiaPrimaId}")
    public ResponseEntity retrieveById (@PathVariable int materiaPrimaId) {
        try {
            MateriaPrimaDTO materiaPrimaDTO = materiaPrimaService.retrieveById(materiaPrimaId);
            return new ResponseEntity(materiaPrimaDTO, HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
