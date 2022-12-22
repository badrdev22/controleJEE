package org.sid.inventoryservice.dto;

public record TicketRequestDTO(
        Double prix,
        Boolean achete,
        Boolean statut,
        Long matchId
) {
}
