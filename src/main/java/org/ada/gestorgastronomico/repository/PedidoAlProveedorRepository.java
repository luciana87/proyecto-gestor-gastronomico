package org.ada.gestorgastronomico.repository;

import org.ada.gestorgastronomico.entity.PedidoAlProveedor;
import org.ada.gestorgastronomico.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoAlProveedorRepository extends JpaRepository<PedidoAlProveedor, Integer> {

    List<PedidoAlProveedor> findByProveedor (Proveedor proveedor);

}
