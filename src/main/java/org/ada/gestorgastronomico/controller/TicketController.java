package org.ada.gestorgastronomico.controller;

import org.ada.gestorgastronomico.dto.TicketDTO;
import org.ada.gestorgastronomico.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody TicketDTO ticketDTO){
        TicketDTO ticketDTO1 = ticketService.create(ticketDTO);

        return new ResponseEntity(ticketDTO1.getNum(), HttpStatus.CREATED);
    }
}
