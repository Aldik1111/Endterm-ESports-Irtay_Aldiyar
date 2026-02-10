package com.example.endtermesportsirtay_aldiyar.repository;

import com.example.endtermesportsirtay_aldiyar.exception.DatabaseException;
import com.example.endtermesportsirtay_aldiyar.utils.DatabaseConnection;
import com.example.endtermesportsirtay_aldiyar.model.Game;
import com.example.endtermesportsirtay_aldiyar.model.Tournament;
import com.example.endtermesportsirtay_aldiyar.repository.impl.JdbcCrudRepository;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class TournamentRepository extends JdbcCrudRepository<Tournament> {

    private final GameRepository gameRepo = new GameRepository();

    @Override
    protected String getTableName() {
        return "tournaments";
    }

    @Override
    protected Tournament mapRowToEntity(ResultSet rs) throws SQLException {
        Game game = gameRepo.findById(rs.getInt("game_id")).orElse(null);
        return new Tournament(rs.getInt("id"),
                rs.getString("name"), game,
                rs.getInt("game_id"));
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Tournament entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.setInt(3, entity.getGame().getId());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Tournament entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getGame().getId());
        ps.setInt(3, entity.getId());
    }

    @Override
    public void update(Tournament tournament) {
        String sql = getUpdateSql();

        try (var conn = DatabaseConnection.getConnection();
             var ps = conn.prepareStatement(sql)) {

            setUpdateParams(ps, tournament);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to update tournament", e);
        }
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO tournaments (id, name, game_id) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateSql() {
        return "UPDATE tournaments SET name = ?, game_id = ? WHERE id = ?";
    }

}
