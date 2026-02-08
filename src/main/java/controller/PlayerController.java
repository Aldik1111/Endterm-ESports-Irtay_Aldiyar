package controller;

import exception.ValidationException;
import model.Player;
import service.PlayerService;

import java.util.List;

public class PlayerController {

    private final PlayerService playerService = new PlayerService();

    public void create(Player player) {
        try {
            playerService.createPlayer(player);
            System.out.println("Player created: " + player.getName());
        } catch (ValidationException e) {
            System.out.println("Failed to create player: " + e.getMessage());
        }
    }


    public void getAll() {
        List<Player> players = playerService.getAllPlayers();
        if (players.isEmpty()) {
            System.out.println("No players found.");
            return;
        }
        players.forEach(System.out::println);
    }

    public void getById(int id) {
        playerService.getPlayerById(id).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Player not found.")
        );
    }

    public void getByTeam(int teamId) {
        List<Player> players = playerService.getByTeam(teamId);
        if (players.isEmpty()) {
            System.out.println("No players in team " + teamId);
            return;
        }
        players.forEach(System.out::println);
    }


    public void update(Player player) {
        playerService.updatePlayer(player);
        System.out.println("Player updated.");
    }

    public void delete(int id) {
        playerService.deletePlayer(id);
        System.out.println("Player deleted.");
    }
}
