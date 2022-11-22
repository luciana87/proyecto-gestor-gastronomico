package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class ProveedorDTO {
    private String cuit;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    @JsonAlias("pedidos_del_proveedor")
    private List<PedidoAlProveedorDTO> pedidosDTO;

    public ProveedorDTO(String cuit, String nombre, String email, String telefono, String direccion) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<PedidoAlProveedorDTO> getPedidosDTO() {
        return pedidosDTO;
    }
}
