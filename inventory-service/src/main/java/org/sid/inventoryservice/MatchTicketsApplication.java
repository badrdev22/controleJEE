package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Match;
import org.sid.inventoryservice.entities.Ticket;
import org.sid.inventoryservice.repository.MatchRepository;
import org.sid.inventoryservice.repository.TicketRepository;
import org.sid.inventoryservice.shared.Helper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class MatchTicketsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MatchTicketsApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(MatchRepository matchRepository, TicketRepository ticketRepository){
        return args -> {
            Random random = new Random();
            List.of("MA_FR","FR_AR","MA_SP").forEach(m->{
                Match match  = Match.builder()
                        .reference(Helper.generateStringId(16))
                        .matchDate(new Date())
                        .equipe1("MA")
                        .equipe2("FR")
                        .lieu("maroc")
                        .build();
                matchRepository.save(match);
            });
            matchRepository.findAll().forEach(m->{
                for (int i = 0; i < 10; i++) {
                    Ticket ticket = Ticket.builder().reference(Helper.generateStringId(16))
                            .statut(true)
                            .achete(false)
                            .prix(100.00)
                            .match(m)
                            .build();
                    ticketRepository.save(ticket);
                }
            });


        };
    }

}
