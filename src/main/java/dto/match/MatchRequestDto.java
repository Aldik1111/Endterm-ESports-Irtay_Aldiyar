package dto.match;

public class MatchRequestDto {

    private int teamAId;
    private int teamBId;
    private int scoreA;
    private int scoreB;
    private int tournamentId;

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
}
