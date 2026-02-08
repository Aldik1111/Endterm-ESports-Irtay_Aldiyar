package service;

import model.Game;
import org.springframework.stereotype.Service;
import repository.GameRepository;
import exception.ValidationException;

import java.util.List;
import java.util.Optional;


@Service
public class GameService {

    private final GameRepository gameRepository = new GameRepository();

    public void createGame(Game game) {
        validateGame(game);
        gameRepository.save(game);
    }

    public Optional<Game> getGameById(int id) {
        return gameRepository.findById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public void updateGame(Game game) {
        validateGame(game);
        gameRepository.save(game);
    }

    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    private void validateGame(Game game) {
        if (game.getName().isEmpty()) {
            throw new ValidationException("Game name cannot be empty");
        }
        if (!game.getGenre().equalsIgnoreCase("MOBA") &&
                !game.getGenre().equalsIgnoreCase("FPS")) {
            throw new ValidationException("Game genre must be MOBA or FPS");
        }
    }
}
