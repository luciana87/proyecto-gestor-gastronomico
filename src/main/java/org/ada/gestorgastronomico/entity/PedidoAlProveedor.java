package org.ada.gestorgastronomico.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido_al_proveedor")
public class PedidoAlProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(name = "monto_total", nullable = false)
    private Double montoTotal;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cuit_proveedor", nullable = false)
    private Proveedor proveedor;

    @OneToMany(mappedBy = "pedidoAlProveedor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ItemPedido> items;

    public PedidoAlProveedor() {
    }

    public PedidoAlProveedor(String estado, Proveedor proveedor) {
        this.fecha = LocalDateTime.now();
        this.estado = estado;
        this.proveedor = proveedor;
        this.items = new ArrayList<>();
        montoTotal = 0.0;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public String getEstado() {
        return estado;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public Integer getNumero() {
        return numero;
    }
    public List<ItemPedido> getItems() {
        return items;
    }
}
