package com.tienda.mayorista.domain;

import java.time.LocalDateTime;

public class Bill {
    private int billId;
    private LocalDateTime timeRequested;
    private int billNumber;
    private int clientId;
    private int vendorId;
    private String orderDetail;
    private Client client;
    private Vendor vendor;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public LocalDateTime getTimeRequested() {
        return timeRequested;
    }

    public void setTimeRequested(LocalDateTime timeRequested) {
        this.timeRequested = timeRequested;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
