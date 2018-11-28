/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.controller;

import java.util.List;
import lk.ijse.pos.business.BOFactory;
import lk.ijse.pos.business.custom.OrderBO;
import lk.ijse.pos.dto.OrderDTO;
import lk.ijse.pos.dto.OrderDetailDTO;

/**
 *
 * @author janith
 */
public class ManageOrdersController {

    private static OrderBO orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDER);

    public static List<OrderDTO> getAllOrders() throws Exception {
        return orderBO.getAllOrders();
    }

    public static boolean saveItem(OrderDTO orderDTO) throws Exception {
        return orderBO.saveOrder(orderDTO);
    }

    public static boolean deleteOrder(String orderId) throws Exception {
        return orderBO.deleteOrder(orderId);
    }
}
