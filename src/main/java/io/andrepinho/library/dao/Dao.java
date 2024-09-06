package io.andrepinho.library.dao;

import java.util.List;

public interface Dao<T> {
    T findById(Integer id);
    List<T> findAll();
    void delete(Integer id);
    T saveOrUpdate(T model);
}
