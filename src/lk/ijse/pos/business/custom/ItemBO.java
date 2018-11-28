/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.List;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDTO;

/**
 *
 * @author ranjith-suranga
 */
public interface ItemBO extends SuperBO{
    
    public List<ItemDTO> getAllItems() throws Exception;
    
    public boolean deleteItem(String code) throws Exception;
    
    public boolean saveItem(ItemDTO dto) throws Exception;
    
    public ItemDTO findItem(String code) throws Exception;
    
    public boolean updateItem(ItemDTO dto) throws Exception;
    
}
