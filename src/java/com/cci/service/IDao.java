package com.cci.service;

import java.util.List;

/**
 *
 * @author Anny Mora
 */
public interface IDao<T> {

    public List<T> getAll();

    public void insert(T data);

    public void delete(T data);

    public void update(T data);

}
