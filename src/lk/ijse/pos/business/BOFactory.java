/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business;

import lk.ijse.pos.business.custom.impl.CustomerBOImpl;
import lk.ijse.pos.business.custom.impl.ItemBOImpl;
import lk.ijse.pos.business.custom.impl.OrderBOImpl;

/**
 *
 * @author ranjith-suranga
 */
public class BOFactory {
    
    public enum BOTypes{
        CUSTOMER, ITEM, ORDER
    }
    
    private static BOFactory bOFactory;
    
    private BOFactory(){
        
    }
    
    public static BOFactory getInstance(){
        if (bOFactory == null){
            bOFactory = new BOFactory();
        }
        return bOFactory;
    }
    
    public SuperBO getBO(BOTypes type){
        switch(type){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case ORDER:
                return new OrderBOImpl();                
            default:
                return null;
        }
    }
    
}
