package service;

import dto.match.MatchRequestDto;
import dto.match.MatchResponseDto;
import model.Match;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    private final List<Match> matches = new ArrayList<>();
    private int idCounter = 1;

    // CREATE
    public void create(MatchRequestDto dto) {
        if (dto.getTeamAId() == dto.getTeamBId()) {
            throw new IllegalArgumentException("Teams must be different");
        }

        Match match = new Match(
                idCounter++,
                dto.getTeamAId(),
                dto.getTeamBId(),
                dto.getTournamentId(),
                dto.getScoreA(),
                dto.getScoreB()
        );

        matches.add(match);
    }

    // READ ALL
    public List<MatchResponseDto> getAll() {
        return matches.stream()
                .map(this::toDto)
                .toList();
    }

    // READ BY ID
    public Optional<MatchResponseDto> getById(int id) {
        return matches.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .map(this::toDto);
    }

    // UPDATE (пересоздаём матч)
    public boolean update(int id, MatchRequestDto dto) {
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getId() == id) {

                Match updated = new Match(
                        id,
                        dto.getTeamAId(),
                        dto.getTeamBId(),
                        dto.getTournamentId(),
                        dto.getScoreA(),
                        dto.getScoreB()
                );

                matches.set(i, updated);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public void delete(int id) {
        matches.removeIf(m -> m.getId() == id);
    }

    private MatchResponseDto toDto(Match m) {
        return new MatchResponseDto(
                m.getId(),
                m.getTeamAId(),
                m.getTeamBId(),
                m.getScoreA(),
                m.getScoreB(),
                m.getTournamentId()
        );
    }
}
