package edu.rsvier.springmvc.dao;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
public abstract class AbstractDao {
     
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public void create(Object entity) {
        getSession().save(entity);
        
    }
     
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    
    public void update(Object entity) {
        try{
        getSession().update(entity);
        }
        catch(Exception ex){
            System.out.println("Update failed, creating new!");
            getSession().persist(entity);
        }
    }

    public Object get(Class c, int id) {
        return getSession().get(c, id);
    }

}