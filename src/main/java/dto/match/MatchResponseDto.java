package dto.match;

public class MatchResponseDto {

    private int id;
    private int teamAId;
    private int teamBId;
    private int scoreA;
    private int scoreB;
    private int tournamentId;

    public MatchResponseDto(int id, int teamAId, int teamBId,
                            int scoreA, int scoreB, int tournamentId) {
        this.id = id;
        this.teamAId = teamAId;
        this.teamBId = teamBId;
        this.scoreA = scoreA;
        this.scoreB = scoreB;
        this.tournamentId = tournamentId;
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
}
