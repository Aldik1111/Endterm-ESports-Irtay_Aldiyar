package com.example.endtermesportsirtay_aldiyar.dto.player;

public class PlayerResponseDto {

    private int id;
    private String nickname;
    private int age;
    private int rank;
    private int teamId;

    public PlayerResponseDto(int id, String nickname, int age, int rank, int teamId) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.rank = rank;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public int getAge() { return age; }

    public int getRank() { return rank; }

    public int getTeamId() { return teamId; }
}
