package org.ada.gestorgastronomico.repository;

import org.ada.gestorgastronomico.entity.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MateriaPrimaRepository extends JpaRepository<MateriaPrima, Integer> {
}
