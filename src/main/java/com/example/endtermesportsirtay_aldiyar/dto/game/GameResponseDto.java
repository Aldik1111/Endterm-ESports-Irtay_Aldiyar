package com.example.endtermesportsirtay_aldiyar.dto.game;

public class GameResponseDto {

    private int id;
    private String name;
    private String genre;
    private int teamSize;

    public GameResponseDto(int id, String name, String genre, int teamSize) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.teamSize = teamSize;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
