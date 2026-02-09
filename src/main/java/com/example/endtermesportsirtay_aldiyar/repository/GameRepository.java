package com.example.endtermesportsirtay_aldiyar.repository;

import com.example.endtermesportsirtay_aldiyar.exception.DatabaseException;
import com.example.endtermesportsirtay_aldiyar.utils.DatabaseConnection;
import com.example.endtermesportsirtay_aldiyar.model.Game;
import com.example.endtermesportsirtay_aldiyar.repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameRepository extends JdbcCrudRepository<Game> {

    @Override
    protected String getTableName() {
        return "games";
    }

    @Override
    protected Game mapRowToEntity(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String genre = rs.getString("genre");
        return new Game(id, name) {
            @Override
            public int getTeamSize() {
                return 0;
            }

            @Override
            public String getGenre() {
                return genre;
            }
        };
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Game entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
        ps.setString(3, entity.getGenre());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Game entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getGenre());
        ps.setInt(3, entity.getId());
    }

    @Override
    public void update(Game game) {
        String sql = getUpdateSql();

        try (var conn = DatabaseConnection.getConnection();
             var ps = conn.prepareStatement(sql)) {

            setUpdateParams(ps, game);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to update game", e);
        }
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO games (id, name, genre) VALUES (?, ?, ?)";
    }

    @Override
    protected String getUpdateSql() {
        return "UPDATE games SET name = ?, genre = ? WHERE id = ?";
    }

}
