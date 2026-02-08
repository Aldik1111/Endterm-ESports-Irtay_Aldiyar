package controller;

import model.Tournament;
import service.TournamentService;

import java.util.List;

public class TournamentController {

    private final TournamentService tournamentService = new TournamentService();

    public void create(Tournament tournament) {
        tournamentService.createTournament(tournament);
        System.out.println("Tournament created: " + tournament.getName());
    }

    public void getAll() {
        List<Tournament> tournaments = tournamentService.getAllTournaments();
        if (tournaments.isEmpty()) {
            System.out.println("No tournaments found.");
            return;
        }
        tournaments.forEach(t -> System.out.println(t.getId() + " | " + t.getName()));
    }

    public void getById(int id) {
        tournamentService.getTournamentById(id).ifPresentOrElse(
                t -> System.out.println(t.getId() + " | " + t.getName()),
                () -> System.out.println("Tournament not found.")
        );
    }

    public void update(Tournament tournament) {
        tournamentService.updateTournament(tournament);
        System.out.println("Tournament updated.");
    }

    public void delete(int id) {
        tournamentService.deleteTournament(id);
        System.out.println("Tournament deleted.");
    }
}
