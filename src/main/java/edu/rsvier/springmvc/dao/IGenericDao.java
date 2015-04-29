package edu.rsvier.springmvc.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

    public void create(T entity);

    public T read(int id);

    public void update(T entity);

    public void delete(T entity);

    public List<T> getAll();

}
