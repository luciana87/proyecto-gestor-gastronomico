package org.ada.gestorgastronomico.repository;

import org.ada.gestorgastronomico.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProveedorRepository extends JpaRepository<Proveedor,String> {
}
