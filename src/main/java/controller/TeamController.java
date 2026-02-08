package controller;

import model.Team;
import service.TeamService;

import java.util.List;

public class TeamController {

    private final TeamService teamService = new TeamService();

    public void create(Team team) {
        teamService.createTeam(team);
        System.out.println("Team created: " + team.getName());
    }

    public void getAll() {
        List<Team> teams = teamService.getAllTeams();
        if (teams.isEmpty()) {
            System.out.println("No teams found.");
            return;
        }
        teams.forEach(t -> System.out.println(t.getId() + " | " + t.getName()));
    }

    public void getById(int id) {
        teamService.getTeamById(id).ifPresentOrElse(
                t -> System.out.println(t.getId() + " | " + t.getName()),
                () -> System.out.println("Team not found.")
        );
    }

    public void update(Team team) {
        teamService.updateTeam(team);
        System.out.println("Team updated.");
    }

    public void delete(int id) {
        teamService.deleteTeam(id);
        System.out.println("Team deleted.");
    }
}
