package model;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends BaseEntity {

    private final Game game;
    private final List<Team> teams;
    private int gameId;

    public Tournament(int id, String name, Game game, int gameId) {
        super(id, name);
        this.game = game;
        this.teams = new ArrayList<>();
        this.gameId = gameId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGameId() {
        return gameId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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

    public Game getGame() { return game; }
    public List<Team> getTeams() { return teams; }


    public void addTeam(Team team) {
        teams.add(team);
    }
}
