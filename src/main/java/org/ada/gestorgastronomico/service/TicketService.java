package org.ada.gestorgastronomico.service;

import org.ada.gestorgastronomico.dto.TicketDTO;
import org.ada.gestorgastronomico.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    public TicketDTO create(TicketDTO ticketDTO) {
        TicketDTO ticketDTO1 = mapToEntity(ticketDTO);
        return null;
    }

    private TicketDTO mapToEntity(TicketDTO ticketDTO) { // Terminar
        Ticket ticket = new Ticket();
        return null;

    }
}
