package com.example.endtermesportsirtay_aldiyar.model;

public class Match extends BaseEntity {

    private int id;
    private int teamAId;
    private int teamBId;
    private int scoreA;
    private int scoreB;
    private int tournamentId;

    public Match(int id, int teamAId, int teamBId, int tournamentId, int scoreA, int scoreB) {
        super(id, "Match: " + id);
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.tournamentId = tournamentId;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        play();
    }

    public void play() {
        this.scoreA = (int) (Math.random() * 10);
        this.scoreB = (int) (Math.random() * 10);
    }

    public int getId() {
        return id;
    }

    public int getTeamAId() {
        return teamAId;
    }

    public int getTeamBId() {
        return teamBId;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreB() {
        return scoreB;
    }

    public int getTournamentId() {
        return tournamentId;
    }

    @Override
    public String getInfo() {
        return "Match: " + id;
    }

    @Override
    public String getEntityType() {
        return "Match";
    }
}
