/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import org.hibernate.Session;

/**
 *
 * @author janith
 */
public interface SuperDAO {
    
    public void setSession(Session session);
    
}
