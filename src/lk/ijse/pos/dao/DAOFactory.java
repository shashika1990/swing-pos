/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.OrderDetailDAO;
import lk.ijse.pos.dao.custom.OrdersDAO;
import lk.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.custom.impl.ItemDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrderDetailDAOImpl;
import lk.ijse.pos.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.pos.dao.custom.impl.QueryDAOImpl;

/**
 *
 * @author ranjith-suranga
 */
public class DAOFactory {
    
    public enum DAOTypes{
        CUSTOMER, ITEM, ORDER, ORDER_DETAIL, QUERY;
    }
    
    private static DAOFactory dAOFactory;
    
    private DAOFactory(){
        
    }
    
    public static DAOFactory getInstance(){
        if (dAOFactory == null){
            dAOFactory = new DAOFactory();
        }
        return dAOFactory;
    }
    
    public SuperDAO getDAO(DAOTypes daoType){
        switch(daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            case ORDER:
                return new OrdersDAOImpl();
            case ORDER_DETAIL:
                return new OrderDetailDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }
    
}