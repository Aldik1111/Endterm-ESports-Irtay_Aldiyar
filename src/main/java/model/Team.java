package model;

import model.interfaces.IRegisterable;
import model.interfaces.IValidatable;

import java.util.ArrayList;
import java.util.List;

public class Team extends BaseEntity implements IRegisterable, IValidatable<Team> {

    private final List<Player> players;
    private boolean registered = false;

    public Team(int id, String name) {
        super(id, name);
        this.players = new ArrayList<>();
    }

    @Override
    public String getEntityType() {
        return "Team";
    }

    @Override
    public String getInfo() {
        return "Team: " + name + " | Players: " + players.size();
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        if (players.size() < 5) {
            players.add(player);
        } else {
            System.out.println("Team is full!");
        }
    }

    public int playerCount() {
        return players.size();
    }

    @Override
    public void register(boolean registered) {
        this.registered = registered;
    }

    public boolean isRegistered() {
        return registered;
    }

    @Override
    public boolean isValid(Team team) {
        return team != null &&
                team.getName() != null &&
                !team.getName().trim().isEmpty() &&
                players.size() <= 5;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}