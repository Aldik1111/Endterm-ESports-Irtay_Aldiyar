package com.example.endtermesportsirtay_aldiyar.repository;

import com.example.endtermesportsirtay_aldiyar.model.Tournament;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TournamentRepository {

    private final List<Tournament> tournaments = new ArrayList<>();

    public void save(Tournament tournament) {
        tournaments.add(tournament);
    }

    public List<Tournament> findAll() {
        return new ArrayList<>(tournaments);
    }

    public Optional<Tournament> findById(int id) {
        return tournaments.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public void deleteById(int id) {
        tournaments.removeIf(t -> t.getId() == id);
    }
}
