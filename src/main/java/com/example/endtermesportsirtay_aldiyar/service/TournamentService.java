package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.model.Tournament;
import com.example.endtermesportsirtay_aldiyar.repository.TournamentRepository;
import org.springframework.stereotype.Service;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;

import java.util.*;

@Service
public class TournamentService {

    private final List<Tournament> tournaments = new ArrayList<>();
    private IdGenerator idGen = IdGenerator.getInstance();
    private TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public void create(Tournament tournament) {
        tournament.setId(idGen.nextId());
        tournaments.add(tournament);
    }

    public List<Tournament> getAll() {
        return tournaments;
    }

    public Optional<Tournament> getById(int id) {
        return tournaments.stream()
                .filter(t -> t.getId() == id)
                .findFirst();
    }

    public boolean update(int id, Tournament updated) {
        for (Tournament t : tournaments) {
            if (t.getId() == id) {
                t.setName(updated.getName());
                t.setGameId(updated.getGameId());
                return true;
            }
        }
        return false;
    }

    public void delete(int id) {
        tournaments.removeIf(t -> t.getId() == id);
    }
}
