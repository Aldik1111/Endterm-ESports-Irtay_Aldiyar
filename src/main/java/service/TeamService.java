package service;

import model.Team;
import repository.TeamRepository;
import exception.ValidationException;

import java.util.List;
import java.util.Optional;

public class TeamService {

    private final TeamRepository teamRepository = new TeamRepository();

    public void createTeam(Team team) {
        validateTeam(team);
        teamRepository.save(team);
    }

    public Optional<Team> getTeamById(int id) {
        return teamRepository.findById(id);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void updateTeam(Team team) {
        validateTeam(team);
        teamRepository.update(team);
    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }

    private void validateTeam(Team team) {
        if (team.getName().isEmpty()) {
            throw new ValidationException("Team name cannot be empty");
        }
    }
}
