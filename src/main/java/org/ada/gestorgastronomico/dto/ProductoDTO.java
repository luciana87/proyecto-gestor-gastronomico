package org.ada.gestorgastronomico.dto;

public class ProductoDTO {

    private Integer codigo;
    private String nombre;
    private double precio;

    public ProductoDTO(Integer codigo, String nombre, double precio) {
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
