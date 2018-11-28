/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.pos.business.custom.OrderBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.OrderDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import lk.ijse.pos.dao.custom.OrdersDAO;
import lk.ijse.pos.dto.OrderDetailDTO;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.OrderDetail_PK;
import lk.ijse.pos.entity.Orders;
import org.hibernate.Transaction;

/**
 *
 * @author janith
 */
public class OrderBOImpl implements OrderBO {

    private OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ORDER);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        Session session = sessionFactory.openSession();
        ordersDAO.setSession(session);
        Transaction transaction = session.beginTransaction();

        double total = 0;
        List<Orders> allOrders = ordersDAO.findAll();
        ArrayList<OrderDTO> dtos = new ArrayList<>();
        for (Orders order : allOrders) {
            List<OrderDetail> orderDetails = order.getOrderDetails();
            
            for (OrderDetail orderDetail : orderDetails) {
                total += orderDetail.getQty() * orderDetail.getUnitPrice();
            }
            dtos.add(new OrderDTO(order.getId(), order.getCustomer().getId(), order.getDate(), total));
        }

        session.getTransaction().commit();
        session.close();

        return dtos;
    }

    @Override
    public boolean deleteOrder(String orderId) throws Exception {
        Session session = sessionFactory.openSession();
        ordersDAO.setSession(session);
        Transaction transaction = session.beginTransaction();

        boolean result = ordersDAO.delete(orderId);

        session.getTransaction().commit();
        session.close();
        return result;
    }

    @Override
    public boolean saveOrder(OrderDTO dto) throws Exception {
        Session session = sessionFactory.openSession();
        ordersDAO.setSession(session);
        Transaction transaction = session.beginTransaction();

        Orders order = new Orders();
        List<OrderDetailDTO> orderDetailsDTOs = dto.getOrderDetails();
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (OrderDetailDTO orderDetailDTO : orderDetailsDTOs) {
            orderDetails.add(new OrderDetail(new OrderDetail_PK(dto.getOrderId(), orderDetailDTO.getItemCode()),
                    (int) orderDetailDTO.getQty(), orderDetailDTO.getUnitPrice()));
        }

        Customer customer = new Customer(dto.getCustomerId(), null, null);

        order.setId(dto.getOrderId());
        order.setDate(dto.getDate());
        order.setCustomer(customer);
        order.setOrderDetails(orderDetails);

        boolean result = ordersDAO.save(order);

        ItemDAO itemDao = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
        itemDao.setSession(session);

        for (OrderDetail orderDetail : orderDetails) {
            Item item = itemDao.find(orderDetail.getOrderDetail_PK().getItemCode());
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            itemDao.update(item);
        }

        session.getTransaction().commit();
        session.close();
        return result;
    }

}
