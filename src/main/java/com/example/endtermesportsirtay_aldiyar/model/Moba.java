package com.example.endtermesportsirtay_aldiyar.model;

public class Moba extends Game {

    public Moba(int id, String name) {
        super(id, name);
    }

    @Override
    public int getTeamSize() {
        return 5;
    }

    @Override
    public String getGenre() {
        return "MOBA";
    }
}
