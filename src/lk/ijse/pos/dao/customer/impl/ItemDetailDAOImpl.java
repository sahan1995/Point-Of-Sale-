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
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.custom.ItemDetalDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.entity.ItemDetail;
import lk.ijse.pos.entity.ItemDetail_PK;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ItemDetailDAOImpl implements ItemDetalDAO {

    @Override
    public ArrayList<ItemDetail> getAll() throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM itemdetail");

        ArrayList<ItemDetail> allitems = new ArrayList<>();
        while (rs.next()) {

            ItemDetail item = new ItemDetail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBigDecimal(4));
            allitems.add(item);

        }
        return allitems;

    }

    @Override
    public boolean save(ItemDetail entity) throws Exception {

        return CrudUitl.executeUpdate("INSERT INTO OrderDetail VALUES (?,?,?,?)", entity.getItemDetail_PK().getItemCode(), entity.getItemDetail_PK().getOrderId(), entity.getQty(), entity.getUnitPrice());
    }

    @Override
    public boolean delete(ItemDetail_PK id) throws Exception {

        return CrudUitl.executeUpdate("DELETE FROM itemdetail WHERE orderId = ? AND itemCode = ?", id.getOrderId(), id.getItemCode());
    }

    @Override
    public ItemDetail findById(ItemDetail_PK id) throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM itemdetail WHERE  orderId = ? AND itemCode = ? ", id.getOrderId(), id.getItemCode());
        if (rs.next()) {
            return new ItemDetail(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getBigDecimal(4));
        } else {
            return null;
        }

    }

    @Override
    public boolean update(ItemDetail entity) throws Exception {
        return CrudUitl.executeUpdate("UPDATE itemdetail qty = ? unitPrice ? WHERE  orderId = ? AND itemCode = ? ", entity.getQty(), entity.getUnitPrice(), entity.getItemDetail_PK().getOrderId(), entity.getItemDetail_PK().getItemCode());

    }

}
