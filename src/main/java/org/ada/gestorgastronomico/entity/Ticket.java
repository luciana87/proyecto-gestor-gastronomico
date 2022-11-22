package org.ada.gestorgastronomico.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    private int num;

    @Column(name = "monto_total", nullable = false)
    private double montoTotal;

    @Column(nullable = false)
    private LocalDate fecha;

    @OneToMany(mappedBy = "ticket", fetch = FetchType.EAGER)
    private List<DetalleTicket> detallesTicket;

    public Ticket() {
    }

    public Ticket(int num, double montoTotal, LocalDate fecha, List<DetalleTicket> detallesTicket) {
        this.num = num;
        this.montoTotal = montoTotal;
        this.fecha = fecha;
        this.detallesTicket = detallesTicket;
    }

    public int getNum() {
        return num;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public List<DetalleTicket> getDetallesTicket() {
        return detallesTicket;
    }
}
