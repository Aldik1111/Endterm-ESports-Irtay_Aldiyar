package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.builder.MatchBuilder;
import com.example.endtermesportsirtay_aldiyar.cache.*;
import com.example.endtermesportsirtay_aldiyar.dto.match.*;
import com.example.endtermesportsirtay_aldiyar.model.Match;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MatchService {

    private final List<Match> matches = new ArrayList<>();
    private final IdGenerator idGen = IdGenerator.getInstance();

    private final CacheManager cache = InMemoryCacheManager.getInstance();
    private static final String MATCH_CACHE_KEY = "all_matches";

    // CREATE
    public void create(MatchRequestDto dto) {

        if (dto.getTeamAId() == dto.getTeamBId()) {
            throw new IllegalArgumentException("Teams must be different");
        }


        Match match = new MatchBuilder()
                .setId(idGen.nextId())
                .setTeamAId(dto.getTeamAId())
                .setTeamBId(dto.getTeamBId())
                .setTournamentId(dto.getTournamentId())
                .setScoreA(dto.getScoreA())
                .setScoreB(dto.getScoreB())
                .build();

        matches.add(match);
        cache.remove(MATCH_CACHE_KEY);
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

    // UPDATE
    public boolean update(int id, MatchRequestDto dto) {
        if (dto.getTeamAId() == dto.getTeamBId()) {
            throw new IllegalArgumentException("Teams must be different");
        }
        for (int i = 0; i < matches.size(); i++) {
            if (matches.get(i).getId() == id) {

                Match updated = new MatchBuilder()
                        .setId(id)
                        .setTeamAId(dto.getTeamAId())
                        .setTeamBId(dto.getTeamBId())
                        .setTournamentId(dto.getTournamentId())
                        .setScoreA(dto.getScoreA())
                        .setScoreB(dto.getScoreB())
                        .build();

                matches.set(i, updated);
                cache.remove(MATCH_CACHE_KEY);

                return true;
            }
        }
        return false;
    }


    // DELETE
    public void delete(int id) {
        matches.removeIf(m -> m.getId() == id);
        cache.remove(MATCH_CACHE_KEY);
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
