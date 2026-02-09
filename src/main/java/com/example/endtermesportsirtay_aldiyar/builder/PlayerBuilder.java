package com.example.endtermesportsirtay_aldiyar.builder;
import com.example.endtermesportsirtay_aldiyar.model.Player;

public class PlayerBuilder {

    private int id;
    private String nickname;
    private int teamId;
    private int rank;
    private int age;

    public PlayerBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public PlayerBuilder setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public PlayerBuilder setTeamId(int teamId) {
        this.teamId = teamId;
        return this;
    }

    public PlayerBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder setRank(int rank) {
        this.rank = rank;
        return this;
    }

    public Player build() {
        Player player = new Player(id, nickname, teamId, rank, age);
        return player;
    }
}
