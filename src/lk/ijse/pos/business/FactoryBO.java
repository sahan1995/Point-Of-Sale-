/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business;

import lk.ijse.pos.business.custom.AddOrderBOCustom;
import lk.ijse.pos.business.custom.impl.AddOrderBOCustomImpl;
import lk.ijse.pos.business.custom.impl.CustomerBOCustomImpl;
import lk.ijse.pos.business.custom.impl.ItemBOCustomImpl;
import lk.ijse.pos.business.custom.impl.ItemDetailBOImpl;
import lk.ijse.pos.business.custom.impl.OrderBOCustomImpl;
import lk.ijse.pos.entity.Customer;

/**
 *
 * @author Sahan Rajakaruna
 */
public class FactoryBO {

    private static FactoryBO getFactoryBO;

    private FactoryBO() {

    }

    public static FactoryBO getInstance() {

        if (getFactoryBO == null) {
            getFactoryBO = new FactoryBO();
        }
        return getFactoryBO;
    }

    public enum BOTyps {
        customer, item, order,itemdetail,addorder;
    }

    public SuperBO getBO(BOTyps bOTyps) {
        switch (bOTyps) {
            case customer:
                return new CustomerBOCustomImpl();
            case item:
                return new ItemBOCustomImpl();
            case order:
                return new OrderBOCustomImpl();
            case itemdetail:
                return new ItemDetailBOImpl();
                case addorder:
                    return new AddOrderBOCustomImpl();
            default:
                return null;

        }

    }

}
