/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.List;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;

/**
 *
 * @author janith
 */
public interface CustomerBO extends SuperBO{
    
     public List<CustomerDTO> getAllCustomers() throws Exception;
     
     public  boolean saveCustomer(CustomerDTO dto) throws Exception;
     
     public  boolean deleteCustomer(String customerID) throws Exception;
     
     public CustomerDTO findCustomer(String id) throws Exception;
     
     public  boolean updateCustomer(CustomerDTO dto) throws Exception;
    
}
