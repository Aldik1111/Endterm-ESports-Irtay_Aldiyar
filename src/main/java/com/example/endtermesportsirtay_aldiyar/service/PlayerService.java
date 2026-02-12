package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.cache.*;
import com.example.endtermesportsirtay_aldiyar.dto.player.*;
import com.example.endtermesportsirtay_aldiyar.model.Player;
import com.example.endtermesportsirtay_aldiyar.cache.*;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;
import com.example.endtermesportsirtay_aldiyar.builder.PlayerBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();
    private final IdGenerator idGen = IdGenerator.getInstance();

    private final CacheManager cache = InMemoryCacheManager.getInstance();
    private static final String PLAYER_CACHE_KEY = "all_players";

    // CREATE
    public void create(PlayerRequestDto dto) {
        Player player = new PlayerBuilder()
            .setId(idGen.nextId())
            .setNickname(dto.getNickname())
            .setAge(dto.getAge())
            .setRank(dto.getRank())
            .setTeamId(dto.getTeamId())
            .build();

        players.add(player);

        cache.remove(PLAYER_CACHE_KEY);
    }

    // READ ALL
    public List<PlayerResponseDto> getAll() { return players.stream() .map(this::toResponseDto) .toList();
    }

    // READ BY ID
    public Optional<PlayerResponseDto> getById(int id) {
        return players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .map(this::toResponseDto);
    }

    // UPDATE
    public boolean update(int id, PlayerRequestDto dto) {
        for (Player player : players) {
            if (player.getId() == id) {
                player.setNickname(dto.getNickname());
                player.setAge(dto.getAge());
                player.setRank(dto.getRank());
                player.setTeamId(dto.getTeamId());
                cache.remove(PLAYER_CACHE_KEY);
                return true;
            }
        }
        return false;
    }

    // DELETE
    public void delete(int id) {
        players.removeIf(p -> p.getId() == id);
        cache.remove(PLAYER_CACHE_KEY);
    }

    private PlayerResponseDto toResponseDto(Player player) {
        return new PlayerResponseDto(
                player.getId(),
                player.getName(),
                player.getAge(),
                player.getRank(),
                player.getTeamId()
        );
    }
}
