package com.example.endtermesportsirtay_aldiyar.model;

public class Fps extends Game {

    public Fps(int id, String name) {
        super(id, name);
    }

    @Override
    public int getTeamSize() {
        return 3;
    }

    @Override
    public String getGenre() {
        return "FPS";
    }
}
