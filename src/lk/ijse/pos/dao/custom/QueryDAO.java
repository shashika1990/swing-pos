/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.custom;

import java.util.ArrayList;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.entity.CustomEntity;

/**
 *
 * @author ranjith-suranga
 */
public interface QueryDAO extends SuperDAO {

    public ArrayList<CustomEntity> getOrderInformation(String orderId) throws Exception;

}
