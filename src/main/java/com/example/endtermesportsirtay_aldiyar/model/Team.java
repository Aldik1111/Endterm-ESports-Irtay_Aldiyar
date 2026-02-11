package com.example.endtermesportsirtay_aldiyar.model;

import java.util.ArrayList;
import java.util.List;

public class Team extends BaseEntity {

    private String country;
    private List<Integer> playerIds;

    public Team(int id, String name, String country) {
        super(id, name);
        this.country = country;
        this.playerIds = new ArrayList<>();
    }

    public String getCountry() {
        return country;
    }

    public List<Integer> getPlayerIds() {
        return playerIds;
    }

    public void addPlayer(int playerId) {
        playerIds.add(playerId);
    }

    public void removePlayer(int playerId) {
        playerIds.remove(Integer.valueOf(playerId));
    }

    @Override
    public String getInfo() {
        return "Team: " + getId() + " | " + getName() + " | Country: " + country;
    }

    @Override
    public String getEntityType() {
        return "Team";
    }
}
