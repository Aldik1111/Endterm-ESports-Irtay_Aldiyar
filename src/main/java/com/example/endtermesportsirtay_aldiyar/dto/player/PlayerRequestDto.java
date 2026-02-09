package com.example.endtermesportsirtay_aldiyar.dto.player;

public class PlayerRequestDto {
    public int rank;
    public int team_id;
    private String nickname;
    private int age;

    public String getNickname() {
        return nickname;
    }

    public int getAge() {
        return age;
    }

    public int getTeamId() {
        return team_id;
    };

    public int getRank() {
        return rank;
    };
}
