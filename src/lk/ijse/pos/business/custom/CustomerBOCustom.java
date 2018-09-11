/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom;

import java.util.ArrayList;
import lk.ijse.pos.business.SuperBO;
import lk.ijse.pos.dto.CustomerDTO;

/**
 *
 * @author Sahan Rajakaruna
 */
public interface CustomerBOCustom extends SuperBO {

    public boolean saveCustomer(CustomerDTO customer) throws Exception;

    public ArrayList<CustomerDTO> getAllCustomers() throws Exception;

    public boolean deleteCustomer(String customerId) throws Exception;

    public CustomerDTO findByid(String id) throws Exception;

    public boolean updateCustomer(CustomerDTO customer) throws Exception;
}
