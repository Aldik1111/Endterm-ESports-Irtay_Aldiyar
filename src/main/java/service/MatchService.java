package service;

import model.Match;
import repository.MatchRepository;
import exception.ValidationException;

import java.util.List;
import java.util.Optional;

public class MatchService {

    private final MatchRepository matchRepository = new MatchRepository();

    public void createMatch(Match match) {
        validateMatch(match);
        matchRepository.save(match);
    }

    public Optional<Match> getMatchById(int id) {
        return matchRepository.findById(id);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public void updateMatch(Match match) {
        validateMatch(match);
        matchRepository.save(match);
    }

    public void deleteMatch(int id) {
        matchRepository.deleteById(id);
    }

    private void validateMatch(Match match) {
        if (match.getTeam1Id() == match.getTeam2Id()) {
            throw new ValidationException("Teams in a match must be different");
        }
    }
}
