package org.sid.inventoryservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sid.inventoryservice.dto.TicketRequestDTO;
import org.sid.inventoryservice.entities.Match;
import org.sid.inventoryservice.entities.Ticket;
import org.sid.inventoryservice.repository.MatchRepository;
import org.sid.inventoryservice.repository.TicketRepository;
import org.sid.inventoryservice.shared.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class TicketService implements IntTicketService {
    private TicketRepository ticketRepository;
    private MatchRepository matchRepository;

    public TicketService(TicketRepository ticketRepository, MatchRepository matchRepository) {
        this.ticketRepository = ticketRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Ticket addTicket(TicketRequestDTO ticketRequest) {
        Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);
        Integer totalticketByMatch  = ticketRepository.countTicketByMatch_Id(match.getId());
        if( totalticketByMatch > 10) {
            throw new RuntimeException("Ticket are not available !");
        }
        Random random = new Random();
        Ticket ticket = new Ticket();
        ticket.setId(random.nextLong());
        ticket.setAchete(false);
        ticket.setReference(Helper.generateStringId(16));
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(true);
        return ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s not found",id))
        );
    }

    @Override
    public Ticket updateTicket(Long id, TicketRequestDTO ticketRequest) {
        Match match = matchRepository.findById(ticketRequest.matchId()).orElse(null);

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                ()->new RuntimeException(String.format("Ticket %s Not founf",id))
        );


        ticket.setId(id);
        ticket.setAchete(ticketRequest.achete());
        ticket.setPrix(ticketRequest.prix());
        ticket.setMatch(match);
        ticket.setStatut(ticketRequest.statut());
        return ticketRepository.save(ticket);
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }

}