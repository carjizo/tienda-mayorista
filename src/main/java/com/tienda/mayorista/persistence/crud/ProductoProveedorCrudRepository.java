package com.tienda.mayorista.persistence.crud;

import com.tienda.mayorista.persistence.entity.ProductoProveedor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoProveedorCrudRepository extends CrudRepository<ProductoProveedor, Integer> {

    Optional<List<ProductoProveedor>> findByIdProducto(int idProducto);
    Optional<List<ProductoProveedor>> findByIdProveedor(int idProveedor);
}
