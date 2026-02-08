package model;

import model.interfaces.IScorable;

public class Match extends BaseEntity implements IScorable {
    private Team team1;
    private Team team2;
    private int score1;
    private int score2;
    private Team winner;
    private Tournament tournament;

    public Match(int id, Team team1, Team team2, Tournament tournament, int score1, int score2) {
        super(id, "Match " + id); // можно использовать id или составное имя
        this.team1 = team1;
        this.team2 = team2;
        this.tournament = tournament;
        this.score1 = score1;
        this.score2 = score2;
    }

    @Override
    public String getEntityType() {
        return "Match";
    }

    @Override
    public String getInfo() {
        return team1.getName() + " VS " + team2.getName() +
                " | Tournament: " + tournament.getName();
    }

    public int getId() {return id;}

    public int getTournamentId() {return tournament.getId();}

    public void playMatch() {
        setScore((int)(Math.random()*10), (int)(Math.random()*10));
    } // give random score

    public void setScore(int score1, int score2){ // set score
        this.score1 = score1;
        this.score2 = score2;
    }

    public int getTeam1Id() {return team1.getId();}
    public int getTeam2Id() {return team2.getId();}

    public Team getWinner() { // Get winner
        if(score1>score2){winner=team1;}
        else if (score1<score2){winner=team2;}
        else{winner = null;}
        return winner;
    }

    public String getResult() {
        getWinner();
        return team1.getName() + " " + score1 + " : " + score2 + " " + team2.getName();
    }

    @Override
    public String toString() {
        return team1.getName() + " VS " + team2.getName() +
                ". Winner: " + (winner != null ? winner.getName() : "Draw");
    }
}
