package com.example.endtermesportsirtay_aldiyar.model;

import java.util.ArrayList;
import java.util.List;

public class Tournament extends BaseEntity {

    private int gameId;
    private List<Integer> teamIds; // Храним id команд
    private String location;

    public Tournament(int id, String name, int gameId) {
        super(id, name);
        this.gameId = gameId;
        this.teamIds = new ArrayList<>();
    }

    public int getGameId() {
        return gameId;
    }

    public List<Integer> getTeamIds() {
        return teamIds;
    }

    public void addTeam(int teamId) {
        teamIds.add(teamId);
    }

    public void removeTeam(int teamId) {
        teamIds.remove(Integer.valueOf(teamId));
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String getInfo() {
        return "Tournament: " + getId() + " | " + getName() + " | Teams: " + teamIds.size();
    }

    @Override
    public String getEntityType() {
        return "Tournament";
    }
}
