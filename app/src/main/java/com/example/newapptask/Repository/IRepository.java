package com.example.newapptask.Repository;

import java.util.List;

public interface IRepository<E> {
    List<E> getList();
    E get(String user);
    void delete(E element);
    void update(E element);
    void insert(E element);
}
