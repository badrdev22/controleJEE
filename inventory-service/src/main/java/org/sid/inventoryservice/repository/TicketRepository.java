package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Ticket;
import org.sid.inventoryservice.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    public Integer countTicketByMatch_Id(Long Id);
}
