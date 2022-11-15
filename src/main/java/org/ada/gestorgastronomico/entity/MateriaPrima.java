package org.ada.gestorgastronomico.entity;

import javax.persistence.*;

@Entity
@Table(name = "materia_prima")
public class MateriaPrima {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private double precio;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer id, String nombre, Integer stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }
}
