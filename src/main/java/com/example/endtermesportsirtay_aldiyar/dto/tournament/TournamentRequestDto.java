package com.example.endtermesportsirtay_aldiyar.dto.tournament;

public class TournamentRequestDto {

    private String name;
    private int gameId;
    private String location;

    public TournamentRequestDto() {}  // <- конструктор по умолчанию

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getGameId() { return gameId; }
    public void setGameId(int gameId) { this.gameId = gameId; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}
