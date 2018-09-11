/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.pos.business.custom.CustomerBOCustom;
import lk.ijse.pos.dao.FactoryDAO;
import lk.ijse.pos.dao.custom.CustomerDAO;
import lk.ijse.pos.dao.customer.impl.CustomerDAOImpl;
import lk.ijse.pos.dto.CustomerDTO;
import lk.ijse.pos.entity.Customer;

/**
 *
 * @author ranjith-suranga
 */
public class CustomerBOCustomImpl implements CustomerBOCustom {

    private CustomerDAO customerDAOImpl = (CustomerDAO) FactoryDAO.getInstance().getDAO(FactoryDAO.DAOTypes.customer);

    public boolean saveCustomer(CustomerDTO customer) throws Exception {

        Customer customerEnty = new Customer(customer.getId(), customer.getName(), customer.getAddress());
        return customerDAOImpl.save(customerEnty);
    }

    public ArrayList<CustomerDTO> getAllCustomers() throws Exception {
        ArrayList<Customer> load = customerDAOImpl.getAll();
        ArrayList<CustomerDTO> getAll = new ArrayList<>();
        for (Customer customer : load) {

            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress());
            getAll.add(customerDTO);

        }
        return getAll;
    }

    public boolean deleteCustomer(String customerId) throws Exception {

        return customerDAOImpl.delete(customerId);
    }

    public CustomerDTO findByid(String id) throws Exception {

        Customer findById = customerDAOImpl.findById(id);
        return new CustomerDTO(findById.getId(), findById.getName(), findById.getAddress());
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) throws Exception {

        return customerDAOImpl.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));

    }

}
