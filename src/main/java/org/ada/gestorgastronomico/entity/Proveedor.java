package org.ada.gestorgastronomico.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private String cuit;

    @Column (nullable = false)
    private String nombre;

    private String email;
    private String telefono;
    private String direccion;

    public Proveedor() {
    }

    public Proveedor(String cuit, String nombre, String email, String telefono, String direccion) {
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
}
