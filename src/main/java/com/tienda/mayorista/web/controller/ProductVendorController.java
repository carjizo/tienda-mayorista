package com.tienda.mayorista.web.controller;


import com.tienda.mayorista.domain.ProductVendor;
import com.tienda.mayorista.domain.service.ProductVendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productvendor")
public class ProductVendorController {

    @Autowired
    private ProductVendorService productVendorService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductVendor>> getAll() {
        return new ResponseEntity<>(productVendorService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductVendor>> getByProduct(@PathVariable("productId") int productId) {
        return productVendorService.getByProduct(productId)
                .map(productVendors -> new ResponseEntity<>(productVendors, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<ProductVendor>> getByVendor(@PathVariable("vendorId") int vendorId) {
        return productVendorService.getByVendor(vendorId)
                .map(productVendors -> new ResponseEntity<>(productVendors, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductVendor> getProductVendor(@PathVariable("id") int productVendorId) {
        return productVendorService.getProductVendor(productVendorId)
                .map(productVendor -> new ResponseEntity<>(productVendor, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<ProductVendor> save(@RequestBody ProductVendor productVendor) {
        return new ResponseEntity<>(productVendorService.save(productVendor), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productVendorId) {
        if (productVendorService.delete(productVendorId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
