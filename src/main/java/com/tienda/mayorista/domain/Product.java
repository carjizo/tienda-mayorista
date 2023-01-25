package com.tienda.mayorista.domain;

import java.time.LocalDateTime;

public class Product {

    private int productId;
    private String name;
    private String category;
    private LocalDateTime dateExpiry;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getDateExpiry() {
        return dateExpiry;
    }

    public void setDateExpiry(LocalDateTime dateExpiry) {
        this.dateExpiry = dateExpiry;
    }
}
