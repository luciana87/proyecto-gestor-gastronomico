package org.ada.gestorgastronomico.entity;

import javax.persistence.*;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {

    @Id
    private int id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "monto_total", nullable = false)
    private double precio_unitario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "numero_pedido", nullable = false)
    private PedidoAlProveedor pedidoAlProveedor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_materia_prima", nullable = false)
    private MateriaPrima materiaPrima;

    public ItemPedido() {
    }

    public ItemPedido(Integer cantidad, double precio_unitario, PedidoAlProveedor pedidoAlProveedor, MateriaPrima materiaPrima) {
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
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
