package service;

import dto.game.GameRequestDto;
import dto.game.GameResponseDto;
import factory.GameFactory;
import model.Game;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    private final List<Game> games = new ArrayList<>();
    private int idCounter = 1;

    // CREATE
    public void create(GameRequestDto dto) {
        Game game = GameFactory.createGame(
                idCounter++,
                dto.getName(),
                dto.getType()
        );
        games.add(game);
    }

    // READ ALL
    public List<GameResponseDto> getAll() {
        return games.stream()
                .map(g -> new GameResponseDto(
                        g.getId(),
                        g.getName(),
                        g.getGenre(),
                        g.getTeamSize()
                ))
                .toList();
    }

    // READ BY ID
    public Optional<GameResponseDto> getById(int id) {
        return games.stream()
                .filter(g -> g.getId() == id)
                .findFirst()
                .map(g -> new GameResponseDto(
                        g.getId(),
                        g.getName(),
                        g.getGenre(),
                        g.getTeamSize()
                ));
    }

    // UPDATE
    public boolean update(int id, GameRequestDto dto) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId() == id) {
                Game updated = GameFactory.createGame(
                        id,
                        dto.getName(),
                        dto.getType()
                );
                games.set(i, updated);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public void delete(int id) {
        games.removeIf(g -> g.getId() == id);
    }
}
