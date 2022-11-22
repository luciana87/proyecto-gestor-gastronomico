package org.ada.gestorgastronomico.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.ada.gestorgastronomico.entity.MateriaPrima;
import org.ada.gestorgastronomico.entity.PedidoAlProveedor;


public class ItemPedidoDTO {


    private Integer id;
    private int cantidad;

    @JsonAlias("precio_unitario")
    private double precio_unitario;

    @JsonAlias("pedido_al_proveedor")
    private PedidoAlProveedor pedidoAlProveedor;

    @JsonAlias("materia_prima")
    private MateriaPrima materiaPrima;


    public ItemPedidoDTO(int cantidad, double precio_unitario, PedidoAlProveedor pedidoAlProveedor, MateriaPrima materiaPrima) {
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.pedidoAlProveedor = pedidoAlProveedor;
        this.materiaPrima = materiaPrima;
    }

    public Integer getId() {
        return id;
    }
    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public PedidoAlProveedor getPedidoAlProveedor() {
        return pedidoAlProveedor;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }
}
