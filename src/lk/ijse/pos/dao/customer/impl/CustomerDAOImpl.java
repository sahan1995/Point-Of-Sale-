/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dao.customer.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import lk.ijse.pos.dao.CrudUitl;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.db.DBConnection;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerDAOImpl implements CustomerDAO {

    public ArrayList<Customer> getAll() throws Exception {

        ResultSet rst = CrudUitl.executeQuery("SELECT * FROM Customer");

        ArrayList<Customer> alCustomers = new ArrayList<>();

        while (rst.next()) {

            Customer customer = new Customer(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3));

            alCustomers.add(customer);

        }

        return alCustomers;

    }

    public Customer findById(String id) throws Exception {

        ResultSet rs = CrudUitl.executeQuery("SELECT * FROM Customer WHERE id = ? ", id);

        if (rs.next()) {

            return new Customer(rs.getString(1), rs.getString(2), rs.getString(3));
        } else {
            return null;
        }

    }

    @Override
    public boolean update(Customer entity) throws Exception {
        return CrudUitl.executeUpdate("UPDATE Customer SET name = ?,address = ? WHERE id = ?", entity.getName(),entity.getAddress(),entity.getId());
    }

    @Override
    public boolean save(Customer customer) throws Exception {

        return CrudUitl.executeUpdate("INSERT INTO Customer VALUES (?,?,?)", customer.getId(), customer.getName(), customer.getAddress());

    }

    @Override
    public boolean delete(String customerId) throws Exception {

        return CrudUitl.executeUpdate("DELETE FROM Customer WHERE id=?", customerId);

    }

}
