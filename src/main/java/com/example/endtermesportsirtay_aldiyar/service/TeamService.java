package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.model.Team;
import com.example.endtermesportsirtay_aldiyar.repository.TeamRepository;
import org.springframework.stereotype.Service;
import com.example.endtermesportsirtay_aldiyar.dto.team.TeamRequestDto;
import com.example.endtermesportsirtay_aldiyar.builder.TeamBuilder;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;

import java.util.*;

@Service
public class TeamService {

    private final List<Team> teams = new ArrayList<>();
    private final IdGenerator idGen = IdGenerator.getInstance();
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public void create(TeamRequestDto dto) {
        Team team = new TeamBuilder()
            .setId(idGen.nextId())
            .setName(dto.getName())
            .build();
        teams.add(team);
    }

    public List<Team> getAll() {
        return teams;
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
}
