package controller;

import model.Match;
import service.MatchService;

import java.util.List;

public class MatchController {

    private final MatchService matchService = new MatchService();

    public void create(Match match) {
        matchService.createMatch(match);
        System.out.println("Match created: " + match.getId());
    }

    public void getAll() {
        List<Match> matches = matchService.getAllMatches();
        if (matches.isEmpty()) {
            System.out.println("No matches found.");
            return;
        }
        matches.forEach(System.out::println);
    }

    public void getById(int id) {
        matchService.getMatchById(id).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Match not found.")
        );
    }

    public void update(Match match) {
        matchService.updateMatch(match);
        System.out.println("Match updated.");
    }

    public void delete(int id) {
        matchService.deleteMatch(id);
        System.out.println("Match deleted.");
    }
}
