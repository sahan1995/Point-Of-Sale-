/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.business.custom.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.ijse.pos.business.custom.ItemDetailBOCustom;
import lk.ijse.pos.dao.FactoryDAO;
import lk.ijse.pos.dao.custom.ItemDetalDAO;
import lk.ijse.pos.dao.customer.impl.ItemDetailDAOImpl;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.dto.ItemDetailDTO;
import lk.ijse.pos.entity.ItemDetail;
import lk.ijse.pos.view.util.tblmodel.OrderTM;

/**
 *
 * @author sahan
 */
public class ItemDetailBOImpl implements ItemDetailBOCustom{

    private ItemDetalDAO itemDetalDAO;
    private Boolean alldone = false;
    public ItemDetailBOImpl() {
        this.itemDetalDAO=(ItemDetalDAO) FactoryDAO.getInstance().getDAO(FactoryDAO.DAOTypes.itemdetail);
    }

    
    @Override
    public boolean addItemDetial(ArrayList<OrderTM> orderTMs) throws Exception {

        for (OrderTM orderTM : orderTMs) {
            
            boolean result = itemDetalDAO.save(new ItemDetail(orderTM.getOrderID(), orderTM.getCode(), orderTM.getQty(), orderTM.getUnitPrice()));
            if(result){
                alldone=true;
            }else{
                alldone=false;
            }
        }
        if(alldone){
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public boolean updateItemDetail(ItemDetailDTO itemDetailDTO) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteItemDetail(String orderId, String ItemCode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ItemDetailDTO> getAllItemDetail() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ItemDTO findById(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
