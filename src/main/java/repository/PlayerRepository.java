package repository;

import exception.DatabaseException;
import model.Match;
import model.Player;
import model.Team;
import repository.impl.JdbcCrudRepository;
//
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository extends JdbcCrudRepository<Player> {

    @Override
    protected String getTableName() {
        return "players";
    }

    @Override
    protected Player mapRowToEntity(ResultSet rs) throws SQLException {
        return new Player(
                rs.getInt("id"),
                rs.getString("nickname"),
                rs.getInt("age"),
                rs.getInt("rank"),
                rs.getInt("team_id")
        );
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Player entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.setInt(3, entity.getAge());
        ps.setInt(4, entity.getRank());
        ps.setInt(5, entity.getTeamId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Player p) throws SQLException {
        ps.setString(1, p.getName());
        ps.setInt(2, p.getAge());
        ps.setInt(3, p.getRank());
        ps.setInt(4, p.getTeamId());
        ps.setInt(5, p.getId());
    }


    @Override
    public void update(Player player) {
        String sql = getUpdateSql();

        try (var conn = utils.DatabaseConnection.getConnection();
             var ps = conn.prepareStatement(sql)) {

            setUpdateParams(ps, player);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new exception.DatabaseException("Failed to update player", e);
        }
    }

    public Player getById(int id) {
        return super.getById(id);
    }

    public List<Player> findByTeamId(int teamId) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE team_id = ?";
        List<Player> players = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, teamId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                players.add(mapRowToEntity(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch players by team", e);
        }
        return players;
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO players (id, nickname, age, rank, team_id) VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected String getUpdateSql() {
        return """
        UPDATE players
        SET nickname = ?, age = ?, rank = ?, team_id = ?
        WHERE id = ?
        """;
    }
}
