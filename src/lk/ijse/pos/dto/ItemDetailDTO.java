/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dto;

import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ItemDetailDTO {

    /**
     * @return the orderd
     */
    public String getOrderd() {
        return orderd;
    }

    /**
     * @param orderd the orderd to set
     */
    public void setOrderd(String orderd) {
        this.orderd = orderd;
    }

    /**
     * @return the itemcode
     */
    public String getItemcode() {
        return itemcode;
    }

    /**
     * @param itemcode the itemcode to set
     */
    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
    private String orderd,itemcode;
    private BigDecimal unitPrice;
    private int qty;

    public ItemDetailDTO() {
    }

    public ItemDetailDTO(String orderd, String itemcode, BigDecimal unitPrice, int qty) {
        this.orderd = orderd;
        this.itemcode = itemcode;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
 
}
