package com.example.endtermesportsirtay_aldiyar.repository.impl;

import com.example.endtermesportsirtay_aldiyar.model.BaseEntity;
import com.example.endtermesportsirtay_aldiyar.repository.interfaces.CrudRepository;
import com.example.endtermesportsirtay_aldiyar.utils.DatabaseConnection;
import com.example.endtermesportsirtay_aldiyar.exception.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class JdbcCrudRepository<T extends BaseEntity> implements CrudRepository<T> {

    protected abstract String getTableName();
    protected abstract T mapRowToEntity(ResultSet rs) throws SQLException;
    protected abstract void setInsertParams(PreparedStatement ps, T entity) throws SQLException;
    protected abstract void setUpdateParams(PreparedStatement ps, T entity) throws SQLException;

    @Override
    public void save(T entity) {
        String sql = getInsertSql();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            setInsertParams(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to save entity", e);
        }
    }

    protected abstract String getInsertSql();


    @Override
    public Optional<T> findById(int id) {
        String sql = "SELECT * FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return Optional.of(mapRowToEntity(rs));
            }
            return Optional.empty();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch entity", e);
        }
    }

    protected abstract String getUpdateSql();


    @Override
    public List<T> findAll() {
        String sql = "SELECT * FROM " + getTableName();
        List<T> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(mapRowToEntity(rs));
            }

        } catch (SQLException e) {
            throw new DatabaseException("Failed to fetch entities", e);
        }
        return list;
    }

    public T getById(int id) {
        return findById(id).orElse(null); // возвращаем объект или null
    }

    @Override
    public void update(T entity) {
        String sql = getUpdateSql();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            setUpdateParams(ps, entity);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to update entity", e);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM " + getTableName() + " WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DatabaseException("Failed to delete entity", e);
        }
    }


}
