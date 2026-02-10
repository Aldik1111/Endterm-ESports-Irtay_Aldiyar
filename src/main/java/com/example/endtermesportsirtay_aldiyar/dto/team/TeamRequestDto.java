package com.example.endtermesportsirtay_aldiyar.dto.team;

public class TeamRequestDto {
    private String name;

    public TeamRequestDto() {}

    public TeamRequestDto(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
