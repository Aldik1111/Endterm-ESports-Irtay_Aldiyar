package service;

import model.Team;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamService {

    private final List<Team> teams = new ArrayList<>();
    private int idCounter = 1;

    public void create(Team team) {
        team.setId(idCounter++);
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
