/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.entity;

import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
public class ItemDetail {

    /**
     * @return the itemDetail_PK
     */
    public ItemDetail_PK getItemDetail_PK() {
        return itemDetail_PK;
    }

    /**
     * @param itemDetail_PK the itemDetail_PK to set
     */
    public void setItemDetail_PK(ItemDetail_PK itemDetail_PK) {
        this.itemDetail_PK = itemDetail_PK;
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
    
    
    private ItemDetail_PK itemDetail_PK;
    private int qty;
    private BigDecimal unitPrice;

    public ItemDetail() {
    }

    public ItemDetail(ItemDetail_PK itemDetail_PK, int qty, BigDecimal unitPrice) {
        this.itemDetail_PK = itemDetail_PK;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
     public ItemDetail(String orderid,String itemcode,int qty, BigDecimal unitPrice) {
        this.itemDetail_PK = new ItemDetail_PK(orderid, itemcode);
        this.qty = qty;
        this.unitPrice = unitPrice;
    }
    
    
}
