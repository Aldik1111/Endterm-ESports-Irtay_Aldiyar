package com.example.endtermesportsirtay_aldiyar.service;

import com.example.endtermesportsirtay_aldiyar.builder.TournamentBuilder;
import com.example.endtermesportsirtay_aldiyar.dto.tournament.*;
import com.example.endtermesportsirtay_aldiyar.model.Tournament;
import com.example.endtermesportsirtay_aldiyar.repository.TournamentRepository;
import com.example.endtermesportsirtay_aldiyar.singleton.IdGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private final TournamentRepository repository;
    private final IdGenerator idGen = IdGenerator.getInstance();

    public TournamentService(TournamentRepository repository) {
        this.repository = repository;
    }

    public TournamentResponseDto create(TournamentRequestDto dto) {
        Tournament tournament = new TournamentBuilder()
                .setId(idGen.nextId())
                .setName(dto.getName())
                .setGameId(dto.getGameId())
                .build();

        repository.save(tournament);
        return toResponseDto(tournament);
    }

    public List<TournamentResponseDto> getAll() {
        return repository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public TournamentResponseDto getById(int id) {
        Tournament t = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tournament not found"));
        return toResponseDto(t);
    }

    public TournamentResponseDto update(int id, TournamentRequestDto dto) {
        Tournament t = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Tournament not found"));

        Tournament updated = new TournamentBuilder()
                .setId(id)
                .setName(dto.getName())
                .setGameId(dto.getGameId())
                .build();

        repository.deleteById(id);
        repository.save(updated);

        return toResponseDto(updated);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    private TournamentResponseDto toResponseDto(Tournament t) {
        return new TournamentResponseDto(
                t.getId(),
                t.getName(),
                t.getGameId()
        );
    }
}
