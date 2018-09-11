/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.ijse.pos.business.custom.ItemBOCustom;
import lk.ijse.pos.dao.FactoryDAO;
import lk.ijse.pos.dao.custom.ItemDAO;
import lk.ijse.pos.dao.customer.impl.ItemDAOImpl;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ItemBOCustomImpl implements ItemBOCustom {

    private ItemDAO itemDAO = (ItemDAO) FactoryDAO.getInstance().getDAO(FactoryDAO.DAOTypes.item);
    private  BigDecimal total = new BigDecimal(0);

    public ArrayList<ItemDTO> getAllItems() throws Exception {

        ArrayList<Item> all = itemDAO.getAll();
        ArrayList<ItemDTO> allDTOs = new ArrayList<>();
        for (Item item : all) {
            ItemDTO itemDTO = new ItemDTO(item.getCode(), item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
            allDTOs.add(itemDTO);
        }
        return allDTOs;
    }

    public boolean saveItem(ItemDTO items) throws Exception {

        return itemDAO.save(new Item(items.getCode(), items.getDescription(), items.getUnitPrice(), items.getQtyOnHand()));

    }

    public boolean deleteItem(String itemCode) throws Exception {

        return itemDAO.delete(itemCode);

    }

    public boolean updateItems(ItemDTO items) throws Exception {

        return itemDAO.update(new Item(items.getCode(), items.getDescription(), items.getUnitPrice(), items.getQtyOnHand()));
    }

    @Override
    public ItemDTO findByid(String id) throws Exception {

        Item findById = itemDAO.findById(id);

        return new ItemDTO(findById.getCode(), findById.getDescription(), findById.getUnitPrice(), findById.getQtyOnHand());

    }

    public BigDecimal gettotal(OrderTM order) {

       
        total = total.add(order.getTotal());
        return total;
    }

}
