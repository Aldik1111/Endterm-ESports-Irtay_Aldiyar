package com.example.endtermesportsirtay_aldiyar.dto.tournament;

import java.util.List;

public class TournamentResponseDto {

    private int id;
    private String name;
    private int gameId;

    public TournamentResponseDto(int id, String name, int gameId) {
        this.id = id;
        this.name = name;
        this.gameId = gameId;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getGameId() { return gameId; }
}
