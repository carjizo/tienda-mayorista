package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.ProductVendor;
import com.tienda.mayorista.domain.repository.ProductVendorRepository;
import com.tienda.mayorista.persistence.crud.ProductoProveedorCrudRepository;
import com.tienda.mayorista.persistence.entity.Producto;
import com.tienda.mayorista.persistence.entity.ProductoProveedor;
import com.tienda.mayorista.persistence.mapper.ProductVendorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoProveedorRepository implements ProductVendorRepository {

    @Autowired
    private ProductoProveedorCrudRepository productoProveedorCrudRepository;

    @Autowired
    private ProductVendorMapper mapper;

    @Override
    public List<ProductVendor> getAll(){
        List<ProductoProveedor> productoProveedors = (List<ProductoProveedor>) productoProveedorCrudRepository.findAll();
        return mapper.toProductVendors(productoProveedors);
    }

    @Override
    public Optional<List<ProductVendor>> getByProduct(int productId) {
        Optional<List<ProductoProveedor>> productoProveedors = productoProveedorCrudRepository.findByIdProducto(productId);
        return productoProveedors.map(productoProveedors1 -> mapper.toProductVendors(productoProveedors1));
    }

    @Override
    public Optional<List<ProductVendor>> getByVendor(int vendorId) {
        Optional<List<ProductoProveedor>> productoProveedors = productoProveedorCrudRepository.findByIdProveedor(vendorId);
        return productoProveedors.map(productoProveedors1 -> mapper.toProductVendors(productoProveedors1));
    }

    @Override
    public Optional<ProductVendor> getProductVendor(int productVendorId) {
        return productoProveedorCrudRepository.findById(productVendorId).map(productoProveedor -> mapper.toProductVendor(productoProveedor));
    }

    @Override
    public ProductVendor save(ProductVendor productVendor) {
        ProductoProveedor productoProveedor = mapper.toProductoProveedor(productVendor);
        return mapper.toProductVendor( productoProveedorCrudRepository.save(productoProveedor));
    }

    @Override
    public void delete(int idProductoProveedor) {
        productoProveedorCrudRepository.deleteById(idProductoProveedor);
    }

}
