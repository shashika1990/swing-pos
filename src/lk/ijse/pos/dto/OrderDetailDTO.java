/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dto;

/**
 *
 * @author janith
 */
public class OrderDetailDTO {

    private String orderId;
    private String itemCode;
    private double unitPrice;
    private double qty;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String orderId, String itemCode, double unitPrice, double qty) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO{" + "orderId=" + orderId + ", itemCode=" + itemCode + ", unitPrice=" + unitPrice + ", qty=" + qty + '}';
    }

}
