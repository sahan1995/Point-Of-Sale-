/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface ItemDetailBOCustom extends SuperBO{

    public boolean addItemDetial(ArrayList<OrderTM> orderTMs) throws Exception;

    public boolean updateItemDetail(ItemDetailDTO itemDetailDTO) throws Exception;

    public boolean deleteItemDetail(String orderId,String ItemCode) throws Exception;

    public ArrayList<ItemDetailDTO> getAllItemDetail() throws Exception;

    public ItemDTO findById(String id) throws Exception;

}
