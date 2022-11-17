package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.gestorgastronomico.entity.Proveedor;

public class PedidoAlProveedorDTO {

    private Integer numero;
    private String fecha;

    @JsonAlias("monto_total")
    private Double montoTotal;

    private String estado;


    @JsonAlias("cuit_proveedor")
    private String proveedorCuit; //Necesito el id del proveedor

    public PedidoAlProveedorDTO(String fecha, Double montoTotal, String estado) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public PedidoAlProveedorDTO(String fecha, Double montoTotal, String estado, String proveedorCuit) { //Constructor con id proveedor
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.proveedorCuit = proveedorCuit;
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

    public String getProveedorCuit() {
        return proveedorCuit;
    }

    public void setProveedorCuit(String proveedorCuit) {
        this.proveedorCuit = proveedorCuit;
    }
}
