package org.sid.inventoryservice.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.sid.inventoryservice.dto.MatchRequestDTO;
import org.sid.inventoryservice.entities.Match;
import org.sid.inventoryservice.repository.MatchRepository;
import org.sid.inventoryservice.shared.Helper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@Transactional
public class MatchService implements IntMatchService{
    private MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public Match addMatch(MatchRequestDTO matchRequest) {
        Random random = new Random();
        Match match = new Match();
        match.setId(random.nextLong());
        match.setLieu(matchRequest.lieu());
        match.setMatchDate(matchRequest.matchDate());
        match.setEquipe1(matchRequest.equipe1());
        match.setEquipe2(matchRequest.equipe2());

        match.setReference(Helper.generateStringId(16));
        return matchRepository.save(match);
    }
    @Override
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }
    @Override
    public Match getMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Match not found")
                );
    }
}
