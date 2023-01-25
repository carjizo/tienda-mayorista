package com.tienda.mayorista.domain.repository;

import com.tienda.mayorista.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();
    Optional<List<Product>> getByCategory(String category);
    Optional<Product> getProduct(int productId);
    Product save(Product product);
    void delete(int productId);
}
