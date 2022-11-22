package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.MateriaPrimaDTO;
import org.ada.gestorgastronomico.entity.MateriaPrima;
import org.ada.gestorgastronomico.repository.MateriaPrimaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MateriaPrimaService {
    private final MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaService(MateriaPrimaRepository materiaPrimaRepository) {
        this.materiaPrimaRepository = materiaPrimaRepository;
    }

    public MateriaPrimaDTO create(MateriaPrimaDTO materiaPrimaDTO){
        MateriaPrima materiaPrima = mapToEntity(materiaPrimaDTO);
        materiaPrima = materiaPrimaRepository.save(materiaPrima);

        return materiaPrimaDTO;
    }

    public List<MateriaPrimaDTO> retrieveAll(){
        List<MateriaPrima> materiaPrimaList = materiaPrimaRepository.findAll();
        return materiaPrimaList.stream().map(person -> mapToDTO(person)).collect(Collectors.toList());

    }

    public MateriaPrimaDTO retrieveById (int id) throws Exception{
        Optional<MateriaPrima> materiaPrima = materiaPrimaRepository.findById(id);
        if (materiaPrima.isEmpty()){
            throw new Exception("Persona no encontrada");
        }
        return mapToDTO(materiaPrima.get());
    }
    public Optional<MateriaPrima> findById(MateriaPrima materiaPrima) {
        return materiaPrimaRepository.findById(materiaPrima.getId());
    }

    private MateriaPrimaDTO mapToDTO(MateriaPrima materiaPrima) {
        MateriaPrimaDTO materiaPrimaDTO = new MateriaPrimaDTO(materiaPrima.getId(),
                materiaPrima.getNombre(), materiaPrima.getStock(), materiaPrima.getPrecio());

        return materiaPrimaDTO;
    }

    private MateriaPrima mapToEntity(MateriaPrimaDTO materiaPrimaDTO) {

        MateriaPrima materiaPrima = new MateriaPrima(materiaPrimaDTO.getId(),
                materiaPrimaDTO.getNombre(), materiaPrimaDTO.getSotck(),
                materiaPrimaDTO.getPrecio());

        return  materiaPrima;
    }


    public void incrementarStock(int cantidad, MateriaPrima materiaPrima) {
        materiaPrima.incrementarStock(cantidad);
        materiaPrimaRepository.save(materiaPrima);
    }
}
