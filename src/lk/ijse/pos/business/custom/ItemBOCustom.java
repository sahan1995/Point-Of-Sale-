/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface ItemBOCustom extends SuperBO {

    public ArrayList<ItemDTO> getAllItems() throws Exception;

    public boolean saveItem(ItemDTO items) throws Exception;

    public boolean deleteItem(String itemCode) throws Exception;

    public boolean updateItems(ItemDTO items) throws Exception;

    public ItemDTO findByid(String id) throws Exception;

    public BigDecimal gettotal(OrderTM order);
}
