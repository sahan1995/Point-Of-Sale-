/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author sahan
 */
public interface AddOrderBOCustom extends SuperBO{
    
    
    public boolean addOrder(OrdersDTO ordersDTO,ArrayList<OrderTM> orderTMlist) throws Exception;
}
