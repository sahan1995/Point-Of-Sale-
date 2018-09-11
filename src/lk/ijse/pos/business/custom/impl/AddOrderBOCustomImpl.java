/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import javax.management.RuntimeErrorException;
import lk.ijse.pos.business.FactoryBO;
import lk.ijse.pos.business.custom.AddOrderBOCustom;
import lk.ijse.pos.business.custom.ItemBOCustom;
import lk.ijse.pos.business.custom.ItemDetailBOCustom;
import lk.ijse.pos.business.custom.OrderBOCustom;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author sahan
 */

public class AddOrderBOCustomImpl implements AddOrderBOCustom {

    private OrderBOCustom orderBOCustom;
    private ItemDetailBOCustom itemDetailBOCustom;
    private ItemBOCustom itemBO;
    private static boolean orderadded = false;
    private static boolean result1 = false;
    private static boolean alldone = false;

    public AddOrderBOCustomImpl() {

        this.itemDetailBOCustom = (ItemDetailBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.itemdetail);
        this.orderBOCustom = (OrderBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.order);
        this.itemBO = (ItemBOCustom) FactoryBO.getInstance().getBO(FactoryBO.BOTyps.item);
    }

    @Override
    public boolean addOrder(OrdersDTO ordersDTO, ArrayList<OrderTM> orderTMs) throws Exception {

        Connection connection = DBConnection.getInstance().getConnection();
        connection.setAutoCommit(false);
        try {

            if (orderadded == false) {
                result1 = orderBOCustom.addOrder(new OrdersDTO(ordersDTO.getOrderid(), ordersDTO.getCustomerid(), ordersDTO.getDate()));
                orderadded = true;

            }

            if (result1) {
                boolean result2 = itemDetailBOCustom.addItemDetial(orderTMs);
                
                if (result2) {
                    alldone = true;
                } else {
                    alldone = false;
                }
            } else {
                connection.rollback();
            }

            if (alldone) { 
                orderadded = false;
                connection.commit();
                return true;
            } else {
                connection.rollback();
                return false;
            }

        } catch (Exception e) {
            connection.rollback();
            throw e;
        }

    }

}
