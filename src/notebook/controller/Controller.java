package notebook.controller;

import model.repository.Operational;

import java.util.List;

public abstract class Controller<T> {
    protected Operational<T> repository;

    public void create(T t) {
        repository.create(t);
    }

    public abstract T get(String id) throws Exception;

    public List<T> getAll() {
        return repository.getAll();
    }

    public abstract void update(String id, T update);

    public void delete(String id) {
        repository.delete(Long.parseLong(id));
    }
}
