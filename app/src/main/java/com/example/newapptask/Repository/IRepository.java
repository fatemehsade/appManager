package com.example.newapptask.Repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<E> {
    List<E> getList();
    E get(UUID id);
    void delete(E element);
    void update(E element);
    void insert(E element);
}
