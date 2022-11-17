package org.ada.gestorgastronomico.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedido_al_proveedor")
public class PedidoAlProveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "monto_total", nullable = false)
    private Double montoTotal;

    @Column(nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cuit_proveedor", nullable = false)
    private Proveedor proveedor;

    public PedidoAlProveedor() {
    }

    public PedidoAlProveedor(LocalDate fecha, Double montoTotal, String estado) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.estado = estado;
    }

    public PedidoAlProveedor(LocalDate fecha, Double montoTotal, String estado, Proveedor proveedor) {
        this.fecha = fecha;
        this.montoTotal = montoTotal;
        this.estado = estado;
        this.proveedor = proveedor;
    }

    public Integer getNumero() {
        return numero;
    }

    public LocalDate getFecha() {
        return fecha;
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

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
