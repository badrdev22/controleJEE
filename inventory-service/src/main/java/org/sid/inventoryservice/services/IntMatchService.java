package org.sid.inventoryservice.services;

import org.sid.inventoryservice.dto.MatchRequestDTO;
import org.sid.inventoryservice.entities.Match;

import java.util.List;

public interface IntMatchService {
    public Match addMatch(MatchRequestDTO matchRequestDTO);
    public List<Match> getAllMatches();
    public Match getMatchById(Long id);
}
