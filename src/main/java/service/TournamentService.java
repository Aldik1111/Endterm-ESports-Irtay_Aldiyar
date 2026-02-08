package service;

import model.Tournament;
import repository.TournamentRepository;
import repository.MatchRepository;
import exception.ValidationException;

import java.util.List;
import java.util.Optional;

public class TournamentService {

    private final TournamentRepository tournamentRepository = new TournamentRepository();

    public void createTournament(Tournament tournament) {
        validateTournament(tournament);
        tournamentRepository.save(tournament);
    }

    public Optional<Tournament> getTournamentById(int id) {
        return tournamentRepository.findById(id);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public void updateTournament(Tournament tournament) {
        validateTournament(tournament);
        tournamentRepository.save(tournament);
    }

    public void deleteTournament(int id) {
        MatchRepository.deleteByTournamentId(id);
        tournamentRepository.deleteById(id);
    }

    private void validateTournament(Tournament tournament) {
        if (tournament.getName() == null || tournament.getName().isEmpty()) {
            throw new ValidationException("Tournament name cannot be empty");
        }
    }
}
