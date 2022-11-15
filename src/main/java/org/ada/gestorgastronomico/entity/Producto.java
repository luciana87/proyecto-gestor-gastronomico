package org.ada.gestorgastronomico.entity;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    // No se auto incrementaba la PK, decía que había que hacerlo manualmente.
    // TODO: https://www.adictosaltrabajo.com/2019/12/26/hibernate-uso-de-generationtype-y-otras-anotaciones/
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private double precio;

    public Producto() {

    }

    public Producto(Integer codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
