package com.example.endtermesportsirtay_aldiyar.dto.team;

public class TeamResponseDto {
    private int id;
    private String name;

    public TeamResponseDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
