package model;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends BaseEntity {

    private final Game game;
    private final List<Team> teams;

    public Tournament(int id, String name, Game game) {
        super(id, name);
        this.game = game;
        this.teams = new ArrayList<>();
    }

    @Override
    public String getEntityType() {
        return "Tournament";
    }

    @Override
    public String getInfo() {
        return "Tournament: " + name +
                " | Game: " + game.getName() +
                " | Teams: " + teams.size();
    }

    public Game getGame() {
        return game;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
