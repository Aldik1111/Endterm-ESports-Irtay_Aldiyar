package com.example.endtermesportsirtay_aldiyar.builder;

import com.example.endtermesportsirtay_aldiyar.model.Match;

public class MatchBuilder {

    private int id;
    private int teamAId;
    private int teamBId;
    private int tournamentId;
    private int scoreA;
    private int scoreB;

    public MatchBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public MatchBuilder setTeamAId(int teamAId) {
        this.teamAId = teamAId;
        return this;
    }

    public MatchBuilder setTeamBId(int teamBId) {
        this.teamBId = teamBId;
        return this;
    }

    public MatchBuilder setTournamentId(int tournamentId) {
        this.tournamentId = tournamentId;
        return this;
    }

    public MatchBuilder setScoreA(int scoreA) {
        this.scoreA = scoreA;
        return this;
    }

    public MatchBuilder setScoreB(int scoreB) {
        this.scoreB = scoreB;
        return this;
    }

    public Match build() {
        Match match = new Match(id, teamAId, teamBId, tournamentId, scoreA, scoreB);
        return match;
    }
}
