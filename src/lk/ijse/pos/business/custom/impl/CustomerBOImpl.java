/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.pos.business.custom.CustomerBO;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerBOImpl implements CustomerBO{

    private  CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    private  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public List<CustomerDTO> getAllCustomers() throws Exception {
        
        Session session = sessionFactory.openSession();
        customerDAO.setSession(session);
        session.beginTransaction();

        List<Customer> allCustomers = customerDAO.findAll();

        List<CustomerDTO> dtos = new ArrayList<>();
        for (Customer customer : allCustomers) {
            CustomerDTO dto = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            dtos.add(dto);
        }
        
        session.getTransaction().commit();
        session.close();
        return dtos;
    }

    public  boolean saveCustomer(CustomerDTO dto) throws Exception {
        
        Session session = sessionFactory.openSession();
        customerDAO.setSession(session);
        session.beginTransaction();        

        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        boolean result =  customerDAO.save(customer);
        
        session.getTransaction().commit();
        session.close();
        
        return result;
    }

    public  boolean deleteCustomer(String customerID) throws Exception {
        
        Session session = sessionFactory.openSession();
        customerDAO.setSession(session);
        session.beginTransaction();        

        boolean result = customerDAO.delete(customerID);
        
        session.getTransaction().commit();
        session.close();
        
        return result;
    }
    
    public CustomerDTO findCustomer(String id) throws Exception {
        Session session = sessionFactory.openSession();
        customerDAO.setSession(session);
        session.beginTransaction();
        
        Customer customer = customerDAO.find(id);
        
        
        session.getTransaction().commit();
        session.close();
        
        return new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws Exception {
        Session session = sessionFactory.openSession();
        customerDAO.setSession(session);
        session.beginTransaction();        

        Customer customer = new Customer(dto.getId(), dto.getName(), dto.getAddress());
        boolean result =  customerDAO.update(customer);
        
        session.getTransaction().commit();
        session.close();
        
        return result;
    }

}
