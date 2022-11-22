package org.ada.gestorgastronomico.dto;


public class MateriaPrimaDTO {

    private int id;
    private String nombre;
    private int sotck;
    private double precio;

    public MateriaPrimaDTO( String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.sotck = stock;
        this.precio = precio;
    }

    public void setId(int id) {
        this.id = id;
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
