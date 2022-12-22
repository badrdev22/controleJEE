package org.sid.inventoryservice.services;

import org.sid.inventoryservice.dto.TicketRequestDTO;
import org.sid.inventoryservice.entities.Ticket;

import java.util.List;

public interface IntTicketService {
    public Ticket addTicket(TicketRequestDTO ticketRequestDTO);
    public List<Ticket> getAllTickets();
    public Ticket getTicketById(Long id);
    public Ticket updateTicket( Long id, TicketRequestDTO ticketRequest);
    public void deleteTicket(Long id);
}