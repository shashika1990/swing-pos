
import java.util.ArrayList;
import lk.ijse.pos.dao.DAOFactory;
import lk.ijse.pos.dao.SuperDAO;
import lk.ijse.pos.dao.custom.QueryDAO;
import lk.ijse.pos.db.HibernateUtil;
import lk.ijse.pos.entity.CustomEntity;
import lk.ijse.pos.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ranjith-suranga
 */
public class TestClass {
    
    public static void main(String[] args) throws Exception {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        session.beginTransaction();
        
        Customer customer = session.find(Customer.class, "C002");
        
        System.out.println(customer);
        
        session.getTransaction().commit();
        
        session.close();
        
        sessionFactory.close();
        
    }
    
}
