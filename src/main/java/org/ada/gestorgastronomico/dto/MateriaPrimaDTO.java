package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class MateriaPrimaDTO {

    private int id;
    private String nombre;
    private int sotck;
    private double precio;

    public MateriaPrimaDTO(int id, String nombre, int stock, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.sotck = stock;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSotck() {
        return sotck;
    }

    public double getPrecio() {
        return precio;
    }
}
