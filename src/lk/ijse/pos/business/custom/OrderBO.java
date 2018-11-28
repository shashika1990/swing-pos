/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.List;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.OrderDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface OrderBO extends SuperBO{
    
    public List<OrderDTO> getAllOrders() throws Exception;
    
    public boolean deleteOrder(String orderId) throws Exception;
    
    public boolean saveOrder(OrderDTO dto) throws Exception;
    
}
