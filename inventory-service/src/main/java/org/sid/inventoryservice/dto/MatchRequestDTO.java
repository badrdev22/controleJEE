package org.sid.inventoryservice.dto;

import org.sid.inventoryservice.entities.Ticket;

import java.util.Date;
import java.util.List;

public record MatchRequestDTO (
        String reference,
        Date matchDate,
        String lieu,
        String equipe1,
        String equipe2,
        List<Ticket> tickets
){}
