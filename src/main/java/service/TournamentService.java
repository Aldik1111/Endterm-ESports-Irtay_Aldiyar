package service;

import model.Tournament;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TournamentService {

    private final List<Tournament> tournaments = new ArrayList<>();
    private int idCounter = 1;

    public void create(Tournament tournament) {
        tournament.setId(idCounter++);
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
