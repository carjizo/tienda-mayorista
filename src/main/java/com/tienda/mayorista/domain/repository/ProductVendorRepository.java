package com.tienda.mayorista.domain.repository;

import com.tienda.mayorista.domain.ProductVendor;

import java.util.List;
import java.util.Optional;

public interface ProductVendorRepository {

    List<ProductVendor> getAll();
    Optional<List<ProductVendor>> getByProduct(int productId);
    Optional<List<ProductVendor>> getByVendor(int vendorId);
    Optional<ProductVendor> getProductVendor(int productVendorId);
    ProductVendor save(ProductVendor productVendor);
    void delete(int productVendorId);
}
