package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PedidoAlProveedorDTO {

    private Integer numero;
    private String fecha;

    @JsonAlias("monto_total")
    private Double montoTotal;

    private String estado;

    public PedidoAlProveedorDTO(String fecha, Double montoTotal, String estado) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public String getEstado() {
        return estado;
    }
}
