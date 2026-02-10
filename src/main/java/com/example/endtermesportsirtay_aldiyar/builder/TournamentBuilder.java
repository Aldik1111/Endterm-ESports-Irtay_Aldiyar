package com.example.endtermesportsirtay_aldiyar.builder;

import com.example.endtermesportsirtay_aldiyar.model.Tournament;
import java.util.ArrayList;
import java.util.List;

public class TournamentBuilder {

    private int id;
    private String name;
    private int gameId;

    public TournamentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TournamentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public TournamentBuilder setGameId(int gameId) {
        this.gameId = gameId;
        return this;
    }

    public Tournament build() {
        Tournament t = new Tournament(id, name, gameId);
        return t;
    }
}
