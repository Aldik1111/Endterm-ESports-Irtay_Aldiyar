package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.model.Player;
import com.example.endtermesportsirtay_aldiyar.model.Team;
import com.example.endtermesportsirtay_aldiyar.repository.TeamRepository;
import org.springframework.stereotype.Service;
import com.example.endtermesportsirtay_aldiyar.dto.team.*;
import com.example.endtermesportsirtay_aldiyar.builder.TeamBuilder;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final List<Team> teams = new ArrayList<>();
    private final IdGenerator idGen = IdGenerator.getInstance();
    private final TeamRepository repository;

    public TeamService(TeamRepository teamRepository){
        this.repository = teamRepository;
    }

    public void create(TeamRequestDto dto) {
        Team team = new TeamBuilder()
                .setId(idGen.nextId())
                .setName(dto.getName())
                .build();
        teams.add(team);
    }



    public List<TeamResponseDto> getAll() {
        return repository.findAll().stream()
                .map(this::toResponseDto)
                .toList();
    }

    public Optional<Team> getById(int id) {
        return teams.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public boolean update(int id, Team updated) {
        for (Team team : teams) {
            if (team.getId() == id) {
                team.setName(updated.getName());
                return true;
            }
        }
        return false;
    }

    public void delete(int id) {
        teams.removeIf(t -> t.getId() == id);
    }

    private TeamResponseDto toResponseDto(Team team) {
        return new TeamResponseDto(
                team.getId(),
                team.getName()
        );
    }
}
