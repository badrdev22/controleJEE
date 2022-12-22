package org.sid.inventoryservice.repository;

import org.sid.inventoryservice.entities.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
