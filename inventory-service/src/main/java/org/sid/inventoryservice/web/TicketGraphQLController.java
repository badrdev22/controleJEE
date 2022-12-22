package org.sid.inventoryservice.web;

import lombok.AllArgsConstructor;
import org.sid.inventoryservice.dto.MatchRequestDTO;
import org.sid.inventoryservice.dto.TicketRequestDTO;
import org.sid.inventoryservice.entities.Match;
import org.sid.inventoryservice.entities.Ticket;
import org.sid.inventoryservice.repository.TicketRepository;
import org.sid.inventoryservice.services.IntMatchService;
import org.sid.inventoryservice.services.IntTicketService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
@AllArgsConstructor
public class TicketGraphQLController {
    private TicketRepository ticketRepository;
    private IntMatchService matchService;
    private IntTicketService ticketService;

    @QueryMapping
    public List<Match> matchs(){
        return matchService.getAllMatches();
    }
    @QueryMapping
    public Match matchById(@Argument Long id){
        return matchService.getMatchById(id);
    }
    @MutationMapping
    public Match saveMatch(@Argument MatchRequestDTO matchRequest){
        return matchService.addMatch(matchRequest);
    }
    @QueryMapping
    public List<Ticket> ticketList(){
        return ticketService.getAllTickets();
    }
    @QueryMapping
    public Ticket ticketById(@Argument Long id){
        return ticketService.getTicketById(id);
    }
    @MutationMapping
    public Ticket saveTicket(@Argument TicketRequestDTO ticketRequest){
        return ticketService.addTicket(ticketRequest);
    }
    @MutationMapping
    public Ticket updateTicket(@Argument Long id,@Argument TicketRequestDTO ticketRequest){
        return ticketService.updateTicket(id,ticketRequest);
    }
    @MutationMapping
    public void deleteTicket(@Argument Long id){
        ticketService.deleteTicket(id);
    }

}
