package repository.impl;

import model.BaseEntity;
import repository.interfaces.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class InMemoryCrudRepository<T extends BaseEntity>
        implements CrudRepository<T> {

    protected final List<T> storage = new ArrayList<>();

    @Override
    public void save(T entity) {
        storage.add(entity);
    }

    @Override
    public Optional<T> findById(int id) {
        return storage.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public void deleteById(int id) {
        storage.removeIf(e -> e.getId() == id);
    }
}
