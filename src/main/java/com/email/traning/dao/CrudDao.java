package com.email.traning.dao;

/**
 * Created by Smeet on 06.06.2017.
 */
public interface CrudDao<T> {
    Long create(T object);
    Long remove(Long id);
    Long update(T object);
    T getById(Long id);
}
