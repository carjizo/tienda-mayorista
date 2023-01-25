package com.tienda.mayorista.domain;

public class RegisterStock {

    private int registerStockId;
    private int productoId;
    private int quantity;
    private Product product;

    public int getRegisterStockId() {
        return registerStockId;
    }

    public void setRegisterStockId(int registerStockId) {
        this.registerStockId = registerStockId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
