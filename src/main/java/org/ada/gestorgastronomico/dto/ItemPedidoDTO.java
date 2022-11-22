package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.gestorgastronomico.entity.MateriaPrima;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;


public class ItemPedidoDTO {


    private Integer id;
    private int cantidad;

    @JsonAlias("precio_unitario")
    private double precioUnitario;

    @JsonAlias("pedido_al_proveedor")
    private String pedidoAlProveedor;

    @JsonAlias("materia_prima")
    private Integer materiaPrima;


    public ItemPedidoDTO(int cantidad, double precioUnitario, String pedidoAlProveedor, Integer materiaPrima) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.pedidoAlProveedor = pedidoAlProveedor;
        this.materiaPrima = materiaPrima;
    }

    public Integer getId() {
        return id;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public String getPedidoAlProveedor() {
        return pedidoAlProveedor;
    }

    public Integer getMateriaPrima() {
        return materiaPrima;
    }
}
