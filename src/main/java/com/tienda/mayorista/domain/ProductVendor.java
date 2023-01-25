package com.tienda.mayorista.domain;

public class ProductVendor {

    private int productVendorId;
    private int productId;
    private int vendorId;
    private Product product;
    private Vendor vendor;

    public int getProductVendorId() {
        return productVendorId;
    }

    public void setProductVendorId(int productVendorId) {
        this.productVendorId = productVendorId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getVendorId() {
        return vendorId;
    }

    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
