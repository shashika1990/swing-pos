/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranjith-suranga
 */
public interface CrudDAO<T, ID> extends SuperDAO{
    
    public boolean save(T entity) throws Exception;
    
    public boolean update(T entity) throws Exception;
    
    public boolean delete(ID key)throws Exception;
    
    public T find(ID key) throws Exception;

    public List<T> findAll() throws Exception;        
    
}
