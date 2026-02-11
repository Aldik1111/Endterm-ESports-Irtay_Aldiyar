package com.example.endtermesportsirtay_aldiyar.builder;

import com.example.endtermesportsirtay_aldiyar.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamBuilder {

    private int id;
    private String name;
    private String country;
    private List<Integer> playerIds = new ArrayList<>();

    public TeamBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TeamBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public TeamBuilder setPlayerIds(List<Integer> playerIds) {
        this.playerIds = playerIds;
        return this;
    }

    public Team build() {
        Team team = new Team(id, name, country);
        if (playerIds != null) {
            for (Integer playerId : playerIds) {
                team.addPlayer(playerId);
            }
        }
        return team;
    }
}
