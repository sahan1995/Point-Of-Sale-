/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.sql.Date;
import java.util.ArrayList;
import lk.ijse.pos.business.FactoryBO;
import lk.ijse.pos.business.custom.OrderBOCustom;
import lk.ijse.pos.dao.FactoryDAO;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.entity.Order;

/**
 *
 * @author Sahan Rajakaruna
 */
public class OrderBOCustomImpl implements OrderBOCustom {

      private OrderDAO order ;
    public OrderBOCustomImpl() {
      order = (OrderDAO) FactoryDAO.getInstance().getDAO(FactoryDAO.DAOTypes.order);
    }

    
  

    @Override
    public boolean addOrder(OrdersDTO ordersDTO) throws Exception {

        return order.save(new Order(ordersDTO.getOrderid(), ordersDTO.getCustomerid(), ordersDTO.getDate()));
    }

    @Override
    public boolean updateOrder(OrdersDTO orders) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteOrder(OrdersDTO orders) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrdersDTO findByID(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
