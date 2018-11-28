/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.db;

import java.io.File;
import lk.ijse.pos.entity.Customer;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.OrderDetail;
import lk.ijse.pos.entity.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

/**
 *
 * @author ranjith-suranga
 */
public class HibernateUtil {
    
    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory(){
        
        File configFile = new File("resources/application.properties");
        
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties(configFile).build();
        
        Metadata metaData = new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class)
                .buildMetadata();
        
        return metaData.getSessionFactoryBuilder().build();
        
    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    
}
