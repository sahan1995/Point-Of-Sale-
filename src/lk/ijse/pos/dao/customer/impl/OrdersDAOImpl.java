/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.customer.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUitl;
import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.OrdersDTO;
import lk.ijse.pos.entity.Order;

/**
 *
 * @author Sahan Rajakaruna
 */
public class OrdersDAOImpl implements OrderDAO {

    public boolean delete(String id) throws Exception {
        return CrudUitl.executeUpdate("DELETE FROM orders WHERE id = ?", id);

    }

    @Override
    public ArrayList<Order> getAll() throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM orders");

        ArrayList<Order> allorders = new ArrayList<>();
        while (rs.next()) {
            allorders.add(new Order(rs.getString(1), rs.getString(2), rs.getDate(3)));

        }
        return allorders;
    }

    @Override
    public boolean save(Order entity) throws Exception {

//        System.out.println(entity.getId());
//        System.out.println(entity.getCustomerId());
//        System.out.println(entity.getDate());
        return CrudUitl.executeUpdate("INSERT INTO `Order` VALUES(?,?,?)", entity.getId(), entity.getDate(), entity.getCustomerId());

    }

    @Override
    public boolean update(Order entity) throws Exception {

        return CrudUitl.executeUpdate("UPDATE orders SET date = ? n customerId =? WHERE id = ?", entity.getDate(), entity.getCustomerId(), entity.getId());
    }

    @Override
    public Order findById(String id) throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM orders WHERE id =? ", id);
        if (rs.next()) {
            return new Order(rs.getString(1), rs.getString(3), rs.getDate(3));
        } else {
            return null;
        }

    }

}
