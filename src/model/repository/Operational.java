package model.repository;

import java.util.List;
import java.util.Optional;

public interface Operational<T> {
    T create(T t);
    List<T> getAll();
    Optional<T> get(Long id);
    Optional<T> update(Long id, T update);
    boolean delete(Long id);
    void save(List<T> els);
}