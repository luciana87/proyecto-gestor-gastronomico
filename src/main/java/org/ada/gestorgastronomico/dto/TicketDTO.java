package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public class TicketDTO {

    private Integer num;

    @JsonAlias("monto_total")
    private double montoTotal;

    private String fecha;

    public TicketDTO(double montoTotal, String fecha) {
        this.montoTotal = montoTotal;
        this.fecha = fecha;
    }

    public Integer getNum() {
        return num;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public String getFecha() {
        return fecha;
    }
}
