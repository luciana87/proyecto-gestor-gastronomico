package org.ada.gestorgastronomico.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "proveedor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PedidoAlProveedor> pedidos;


    public Proveedor() {
    }

    public Proveedor(String cuit, String nombre, String email, String telefono, String direccion, List<PedidoAlProveedor> pedidos) {
        this.cuit = cuit;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pedidos = pedidos;
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

    public List<PedidoAlProveedor> getPedidos() {
        if (pedidos == null){
            pedidos = new ArrayList<>();
        }
        return pedidos;
    }
}
