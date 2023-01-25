package com.tienda.mayorista.domain.service;

import com.tienda.mayorista.domain.ProductVendor;
import com.tienda.mayorista.domain.repository.ProductVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVendorService {

    @Autowired
    private ProductVendorRepository productVendorRepository;

    public List<ProductVendor> getAll() {
        return productVendorRepository.getAll();
    }

    public Optional<List<ProductVendor>> getByProduct(int productId) {
        return productVendorRepository.getByProduct(productId);
    }

    public Optional<List<ProductVendor>> getByVendor(int vendorId) {
        return productVendorRepository.getByVendor(vendorId);
    }

    public Optional<ProductVendor> getProductVendor(int productVendorId) {
        return productVendorRepository.getProductVendor(productVendorId);
    }

    public ProductVendor save(ProductVendor productVendor) {
        return productVendorRepository.save(productVendor);
    }

    public boolean delete(int productVendorId) {
        return getProductVendor(productVendorId).map(productVendor -> {
            productVendorRepository.delete(productVendorId);
            return true;
        }).orElse(false);
    }
}
