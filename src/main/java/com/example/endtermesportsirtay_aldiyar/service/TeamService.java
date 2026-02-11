package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.builder.TeamBuilder;
import com.example.endtermesportsirtay_aldiyar.dto.team.*;
import com.example.endtermesportsirtay_aldiyar.model.Team;
import com.example.endtermesportsirtay_aldiyar.repository.TeamRepository;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository repository;
    private final IdGenerator idGen = IdGenerator.getInstance();

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
        return toResponseDto(team);
    }

    // READ ALL
    public List<TeamResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
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

        return toResponseDto(updated);
    }

    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
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
