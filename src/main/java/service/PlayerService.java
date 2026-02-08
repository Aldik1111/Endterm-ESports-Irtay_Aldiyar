package service;

import dto.player.PlayerRequestDto;
import dto.player.PlayerResponseDto;
import model.Player;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PlayerService {

    private final List<Player> players = new ArrayList<>();
    private int idCounter = 1;

    // CREATE
    public void create(PlayerRequestDto dto) {
        Player player = new Player(
            idCounter++,
            dto.getNickname(),
            dto.getAge(),
                dto.getRank,
                dto.getTeamId
        );

        players.add(player);

        player.setId(idCounter++);
        player.setNickname(dto.getNickname());
        player.setAge(dto.getAge());
        players.add(player);
    }

    // READ ALL
    public List<PlayerResponseDto> getAll() {
        return players.stream()
                .map(this::toResponseDto)
                .toList();
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
                return true;
            }
        }
        return false;
    }

    // DELETE
    public void delete(int id) {
        players.removeIf(p -> p.getId() == id);
    }

    private PlayerResponseDto toResponseDto(Player player) {
        return new PlayerResponseDto(
                player.getId(),
                player.getName(),
                player.getAge()
        );
    }
}
