/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.pos.dto;

import java.util.Date;
import java.util.List;

/**
 *
 * @author janith
 */
public class OrderDTO {

    private String orderId;
    private String customerId;
    private Date date;
    private List<OrderDetailDTO> orderDetails;
    private double invoiceAmount;

    public OrderDTO() {
    }

    public OrderDTO(String orderId, String customerId, Date date, List<OrderDetailDTO> orderDetails) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.orderDetails = orderDetails;
    }

    public OrderDTO(String orderId, String customerId, Date date, double invoiceAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.date = date;
        this.invoiceAmount = invoiceAmount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" + "orderId=" + orderId + ", customerId=" + customerId + ", date=" + date + ", orderDetails=" + orderDetails + ", invoiceAmount=" + invoiceAmount + '}';
    }

}
