package com.example.endtermesportsirtay_aldiyar.builder;

import com.example.endtermesportsirtay_aldiyar.model.Team;

public class TeamBuilder {

    private int id;
    private String name;

    public TeamBuilder setId(int id){
        this.id = id;
        return this;
    }

    public TeamBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public Team build(){
        Team team = new Team(id, name);
        return team;
    }

}

