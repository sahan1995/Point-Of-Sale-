/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao;

import lk.ijse.pos.dao.customer.impl.CustomerDAOImpl;
import lk.ijse.pos.dao.customer.impl.ItemDAOImpl;
import lk.ijse.pos.dao.customer.impl.ItemDetailDAOImpl;
import lk.ijse.pos.dao.customer.impl.OrdersDAOImpl;

/**
 *
 * @author Sahan Rajakaruna
 */
public class FactoryDAO {

    private static FactoryDAO getFactoryDAO;

    private FactoryDAO() {

    }

    public static FactoryDAO getInstance() {
        if (getFactoryDAO == null) {
            getFactoryDAO = new FactoryDAO();
        }
        return getFactoryDAO;
    }

    public enum DAOTypes {
        customer, order, item, itemdetail;
    }

    public SuperDAO getDAO(DAOTypes dAOTypes) {
        switch (dAOTypes) {
            case customer:
                return new CustomerDAOImpl();
            case order:
                return new OrdersDAOImpl();

            case item:
                return new ItemDAOImpl();
            case itemdetail:
                return new ItemDetailDAOImpl();
            default:
                return null;
        }
    }

}
