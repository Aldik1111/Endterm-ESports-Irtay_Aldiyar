import controller.*;
import model.*;
import service.*;

public class Main {

    public static void main(String[] args) {
        // Controllers
        GameController gameController = new GameController();;
        TeamController teamController = new TeamController();
        PlayerController playerController = new PlayerController();
        TournamentController tournamentController = new TournamentController();
        MatchController matchController = new MatchController();

        System.out.println("=== ESports App Demo ===\n");

        // Games
        Game dota = new Moba(1, "Dota 2");
        Game csgo = new Fps(2, "CS:GO");

        gameController.create(dota);
        gameController.create(csgo);

        System.out.println("\n--- All Games ---");
        gameController.getAll();

        // Commands
        Team teamA = new Team(1, "Team Alpha");
        Team teamB = new Team(2, "Team Bravo");
        Team teamC = new Team(3, "Team Charlie");

        teamController.create(teamA);
        teamController.create(teamB);
        teamController.create(teamC);

        System.out.println("\n--- All Teams ---");
        teamController.getAll();

        // PLayers
        Player p1 = new Player(1, "Allan", 20, 5, teamA.getId());
        Player p2 = new Player(2, "Plasha", 22, 6, teamA.getId());
        Player p3 = new Player(3, "Piter", 19, 7, teamB.getId());

        playerController.create(p1);
        playerController.create(p2);
        playerController.create(p3);

        System.out.println("\n--- Players in Team Alpha ---");
        playerController.getById(teamA.getId());

        // Tournaments
        Tournament tour1 = new Tournament(1, "Winter Cup", dota);
        tournamentController.create(tour1);

        System.out.println("\n--- All Tournaments ---");
        tournamentController.getAll();

        // Matches
        Match match1 = new Match(1, teamA, teamB, tour1, 0, 0);
        match1.playMatch();
        matchController.create(match1);

        System.out.println("\n--- All Matches ---");
        matchController.getAll();

        // commands
        teamA.setName("Team Alpha Updated");
        teamController.update(teamA);

        System.out.println("\n--- Teams after update ---");
        teamController.getAll();

        // Delete player
        System.out.println("\nDeleting Player3...");
        playerController.delete(3);

        System.out.println("\n--- All Players ---");
        playerController.getAll();

        // delete tournament
        System.out.println("\nDeleting Tournament Winter Cup...");
        tournamentController.delete(1);

        System.out.println("\n--- All Tournaments ---");
        tournamentController.getAll();

        System.out.println("\n=== Demo Finished ===");
    }
}
