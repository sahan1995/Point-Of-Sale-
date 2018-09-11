/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.customer.impl;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUitl;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ItemDAOImpl implements ItemDAO {

    @Override
    public ArrayList<Item> getAll() throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM Item");

        ArrayList<Item> allItems = new ArrayList<>();
        while (rs.next()) {

            Item itemEntity = new Item(rs.getString(1), rs.getString(2),rs.getBigDecimal(3),rs.getInt(4));
            allItems.add(itemEntity);

        }
        return allItems;
    }

    @Override
    public boolean save(Item items) throws Exception {

        return CrudUitl.executeUpdate("INSERT INTO Item VALUES (?,?,?,?)", items.getCode(), items.getDescription(), items.getUnitPrice(), items.getQtyOnHand());

    }

    @Override
    public boolean delete(String itemcode) throws Exception {

        return CrudUitl.executeUpdate("DELETE FROM Item WHERE code = ?", itemcode);

    }

    @Override
    public Item findById(String id) throws Exception {
        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM Item WHERE code = ?", id);

        if (rs.next()) {
            return new Item(rs.getString(1), rs.getString(2),rs.getBigDecimal(3),rs.getInt(4));
        } else {
            return null;
        }

    }

    @Override
    public boolean update(Item items) throws Exception {

        return CrudUitl.executeUpdate("UPDATE Item SET description =?,unitPrice=?,qtyOnHand = ? WHERE code = ?", items.getDescription(), items.getUnitPrice(), items.getQtyOnHand(), items.getCode());

    }

}
