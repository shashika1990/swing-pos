/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author janith
 */
public class CrudDAOImpl<T, ID> implements CrudDAO<T, ID>{
    
    private Session session;
    private Class<T> entity;
    
    public CrudDAOImpl(){
        entity = (Class<T>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }
    
    @Override
    public void setSession(Session session) {
        this.session = session;
    }    

    @Override
    public boolean save(T entity) throws Exception {
        session.persist(entity);
        return true;
    }

    @Override
    public boolean update(T entity) throws Exception {
        session.update(entity);
        return true;
    }

    @Override
    public boolean delete(ID key) throws Exception {
        T entity = find(key);
        session.remove(entity);
        return true;
    }

    @Override
    public T find(ID key) throws Exception {
        return  session.find(entity, key);
    }

    @Override
    public List<T> findAll() throws Exception {
        return session.createQuery("FROM " + entity.getName()).list();
    }
    
}