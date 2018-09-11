/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.view.util.tblmodel;

import java.math.BigDecimal;

/**
 *
 * @author Sahan Rajakaruna
 */
public class OrderTM {
    
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
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
    
    private String OrderID;
    private String code;
    private String desc;
    private BigDecimal unitPrice;
    private BigDecimal total;
    private int qty;

    public OrderTM() {
    }

    public OrderTM(String OrderID, String code, String desc, BigDecimal unitPrice, BigDecimal total, int qty) {
        this.OrderID = OrderID;
        this.code = code;
        this.desc = desc;
        this.unitPrice = unitPrice;
        this.total = total;
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderTM{" + "OrderID=" + OrderID + ", code=" + code + ", desc=" + desc + ", unitPrice=" + unitPrice + ", total=" + total + ", qty=" + qty + '}';
    }

    

    /**
     * @return the OrderID
     */
    public String getOrderID() {
        return OrderID;
    }

    /**
     * @param OrderID the OrderID to set
     */
    public void setOrderID(String OrderID) {
        this.OrderID = OrderID;
    }
    
    
}
