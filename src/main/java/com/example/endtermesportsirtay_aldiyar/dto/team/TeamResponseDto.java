package com.example.endtermesportsirtay_aldiyar.dto.team;

import java.util.List;

public class TeamResponseDto {

    private int id;
    private String name;
    private String country;
    private List<Integer> playerIds;

    public TeamResponseDto(int id, String name, String country, List<Integer> playerIds) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.playerIds = playerIds;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCountry() { return country; }
    public List<Integer> getPlayerIds() { return playerIds; }
}
