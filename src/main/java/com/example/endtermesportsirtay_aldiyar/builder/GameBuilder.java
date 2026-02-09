package com.example.endtermesportsirtay_aldiyar.builder;

import com.example.endtermesportsirtay_aldiyar.model.Game;
import com.example.endtermesportsirtay_aldiyar.model.Team;

public class GameBuilder {

    private int id;
    private String name;

    public GameBuilder setId(int id){
        this.id = id;
        return this;
    }

    public GameBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Game build(){
        Game game = new Game(id, name) {

            @Override
            public int getTeamSize() {
                return 0;
            }

            @Override
            public String getGenre() {
                return "";
            }
        };
        return game;
    }
}
