package com.example.endtermesportsirtay_aldiyar.repository;

import com.example.endtermesportsirtay_aldiyar.model.Team;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TeamRepository {

    private final List<Team> teams = new ArrayList<>();

    public void save(Team team) {
        teams.add(team);
    }

    public List<Team> findAll() {
        return new ArrayList<>(teams);
    }

    public Optional<Team> findById(int id) {
        return teams.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public void deleteById(int id) {
        teams.removeIf(t -> t.getId() == id);
    }
}
