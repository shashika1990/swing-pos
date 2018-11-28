/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.pos.business.custom.ItemBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ranjith-suranga
 */
public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO = (ItemDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<ItemDTO> getAllItems() throws Exception {

        Session session = sessionFactory.openSession();
        itemDAO.setSession(session);
        session.beginTransaction();

        List<Item> allItems = itemDAO.findAll();
        List<ItemDTO> dtos = new ArrayList<>();
        allItems.stream().forEach((item) -> {
            dtos.add(new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        });

        session.getTransaction().commit();
        session.close();

        return dtos;
    }

    public boolean deleteItem(String code) throws Exception {

        Session session = sessionFactory.openSession();
        itemDAO.setSession(session);
        session.beginTransaction();

        boolean result = itemDAO.delete(code);

        session.getTransaction().commit();
        session.close();

        return result;
    }

    public boolean saveItem(ItemDTO dto) throws Exception {

        Session session = sessionFactory.openSession();
        itemDAO.setSession(session);
        session.beginTransaction();

        Item item = new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
        boolean result = itemDAO.save(item);

        session.getTransaction().commit();
        session.close();

        return result;
    }

    @Override
    public ItemDTO findItem(String code) throws Exception {
        Session session = sessionFactory.openSession();
        itemDAO.setSession(session);
        session.beginTransaction();

        Item item = itemDAO.find(code);

        session.getTransaction().commit();
        session.close();

        if (item != null) {
            return new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
        } else {
            return null;
        }
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws Exception {
        Session session = sessionFactory.openSession();
        itemDAO.setSession(session);
        session.beginTransaction();

        Item item = new Item(dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
        boolean result = itemDAO.update(item);

        session.getTransaction().commit();
        session.close();
        return result;
    }

}
