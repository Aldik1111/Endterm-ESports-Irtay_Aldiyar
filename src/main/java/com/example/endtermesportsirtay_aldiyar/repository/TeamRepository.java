package com.example.endtermesportsirtay_aldiyar.repository;

import com.example.endtermesportsirtay_aldiyar.exception.DatabaseException;
import com.example.endtermesportsirtay_aldiyar.utils.DatabaseConnection;
import com.example.endtermesportsirtay_aldiyar.model.Team;
import com.example.endtermesportsirtay_aldiyar.repository.impl.JdbcCrudRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamRepository extends JdbcCrudRepository<Team> {

    @Override
    protected String getTableName() {
        return "teams";
    }

    @Override
    protected Team mapRowToEntity(ResultSet rs) throws SQLException {
        return new Team(rs.getInt("id"), rs.getString("name"));
    }

    @Override
    protected void setInsertParams(PreparedStatement ps, Team entity) throws SQLException {
        ps.setInt(1, entity.getId());
        ps.setString(2, entity.getName());
    }

    @Override
    protected void setUpdateParams(PreparedStatement ps, Team entity) throws SQLException {
        ps.setString(1, entity.getName());
        ps.setInt(2, entity.getId());
    }

    @Override
    public void update(Team team) {
        String sql = getUpdateSql();

        try (var conn = DatabaseConnection.getConnection();
             var ps = conn.prepareStatement(sql)) {

            setUpdateParams(ps, team);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to update team", e);
        }
    }

    @Override
    protected String getInsertSql() {
        return "INSERT INTO teams (id, name) VALUES (?, ?)";
    }


    @Override
    protected String getUpdateSql() {
        return "UPDATE teams SET name = ? WHERE id = ?";
    }
}
