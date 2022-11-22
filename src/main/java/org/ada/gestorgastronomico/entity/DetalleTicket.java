package org.ada.gestorgastronomico.entity;

import javax.persistence.*;

@Entity
@Table(name = "detalle_ticket")
public class DetalleTicket {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name = "num_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

}
