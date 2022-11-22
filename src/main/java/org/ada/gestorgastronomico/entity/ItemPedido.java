package org.ada.gestorgastronomico.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    private int id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false)
    private double precioUnitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numero_pedido", nullable = false)
    private PedidoAlProveedor pedidoAlProveedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materia_prima", nullable = false)
    private MateriaPrima materiaPrima;

    public ItemPedido() {
    }

    public ItemPedido(Integer cantidad, double precioUnitario, PedidoAlProveedor pedidoAlProveedor, MateriaPrima materiaPrima) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.pedidoAlProveedor = pedidoAlProveedor;
        this.materiaPrima = materiaPrima;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPrecioUnitario(double precio_unitario) {
        this.precioUnitario = precio_unitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public PedidoAlProveedor getPedidoAlProveedor() {
        return pedidoAlProveedor;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }
}
