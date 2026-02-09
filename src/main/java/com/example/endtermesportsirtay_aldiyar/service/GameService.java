package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.dto.game.GameRequestDto;
import com.example.endtermesportsirtay_aldiyar.dto.game.GameResponseDto;
import com.example.endtermesportsirtay_aldiyar.factory.GameFactory;
import com.example.endtermesportsirtay_aldiyar.model.Game;
import org.springframework.stereotype.Service;

import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;
import java.util.*;

@Service
public class GameService {

    private final List<Game> games = new ArrayList<>();
    private final IdGenerator idGen = IdGenerator.getInstance();
    // CREATE
    public void create(GameRequestDto dto) {
        Game game = GameFactory.createGame(
                idGen.nextId(),
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
