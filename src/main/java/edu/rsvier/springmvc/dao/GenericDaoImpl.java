package edu.rsvier.springmvc.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoImpl<T extends Serializable> implements IGenericDao<T> {

    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }
    
    public void flushSession(){
        getSession().flush();
        getSession().clear();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> getType() {
        return this.type;
    }

    public final void setType(Class<T> typeToSet) {
        this.type = typeToSet;
    }

    public void create(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().merge(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public T read(int id) {
        return (T) getSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        
        return getSession().createQuery("from " + type.getName()).list();
    }

}
