package org.ada.gestorgastronomico.entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class DetalleTicket {

    @ManyToOne
    @JoinColumn(name = "num_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "codigo_producto")
    private Producto producto;

}
