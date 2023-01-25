package com.tienda.mayorista.persistence.crud;

import com.tienda.mayorista.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByCategoria(String categoria);

}
