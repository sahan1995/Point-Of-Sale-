/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.OrdersDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface OrderBOCustom extends SuperBO {

    public boolean addOrder(OrdersDTO orders) throws Exception;
    
    public boolean updateOrder(OrdersDTO orders) throws Exception;
    
    public boolean deleteOrder(OrdersDTO orders) throws Exception;
    
    public ArrayList<OrdersDTO> getAllOrders() throws Exception;
    
    public OrdersDTO findByID(String id) throws Exception;
    
    
}
 