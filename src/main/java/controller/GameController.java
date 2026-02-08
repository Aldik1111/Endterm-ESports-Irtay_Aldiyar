package controller;

import model.Game;
import service.GameService;

import java.util.List;

public class GameController {

    private final GameService gameService = new GameService();

    public void create(Game game) {
        gameService.createGame(game);
        System.out.println("Game created: " + game.getName());
    }

    public void getAll() {
        List<Game> games = gameService.getAllGames();
        if (games.isEmpty()) {
            System.out.println("No games found.");
            return;
        }
        games.forEach(g -> System.out.println(g.getId() + " | " + g.getName() + " | Genre: " + g.getGenre()));
    }

    public void getById(int id) {
        gameService.getGameById(id).ifPresentOrElse(
                g -> System.out.println(g.getId() + " | " + g.getName() + " | Genre: " + g.getGenre()),
                () -> System.out.println("Game not found.")
        );
    }

    public void update(Game game) {
        gameService.updateGame(game);
        System.out.println("Game updated.");
    }

    public void delete(int id) {
        gameService.deleteGame(id);
        System.out.println("Game deleted.");
    }
}
