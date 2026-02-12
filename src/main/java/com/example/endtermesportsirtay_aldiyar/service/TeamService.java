package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.builder.TeamBuilder;
import com.example.endtermesportsirtay_aldiyar.dto.team.*;
import com.example.endtermesportsirtay_aldiyar.model.Team;
import com.example.endtermesportsirtay_aldiyar.repository.TeamRepository;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;
import com.example.endtermesportsirtay_aldiyar.cache.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final IdGenerator idGen = IdGenerator.getInstance();

    private final CacheManager cache = InMemoryCacheManager.getInstance();
    private static final String TEAM_CACHE_KEY = "all_teams";

    public TeamService(TeamRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public TeamResponseDto create(TeamRequestDto dto) {

        Team team = new TeamBuilder()
                .setId(idGen.nextId())
                .setName(dto.getName())
                .setCountry(dto.getCountry())
                .build();

        repository.save(team);

        cache.remove(TEAM_CACHE_KEY);
        return toResponseDto(team);
    }

    // READ ALL
    public List<TeamResponseDto> getAll() {

        if (cache.contains(TEAM_CACHE_KEY)) {
            System.out.println("Returning teams from CACHE");
            return (List<TeamResponseDto>) cache.get(TEAM_CACHE_KEY);
        }

        System.out.println("Fetching teams from REPOSITORY");

        List<TeamResponseDto> teams = repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());

        cache.put(TEAM_CACHE_KEY, teams);

        return teams;
    }

    // READ BY ID
    public TeamResponseDto getById(int id) {
        Team team = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found"));

        return toResponseDto(team);
    }

    // UPDATE
    public TeamResponseDto update(int id, TeamRequestDto dto) {
        Team existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Team not found"));

        Team updated = new TeamBuilder()
                .setId(id)
                .setName(dto.getName())
                .setCountry(dto.getCountry())
                .setPlayerIds(existing.getPlayerIds())
                .build();

        repository.deleteById(id);
        repository.save(updated);

        cache.remove(TEAM_CACHE_KEY);

        return toResponseDto(updated);
    }

    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
        cache.remove(TEAM_CACHE_KEY);
    }

    private TeamResponseDto toResponseDto(Team team) {
        return new TeamResponseDto(
                team.getId(),
                team.getName(),
                team.getCountry(),
                team.getPlayerIds()
        );
    }
}
