package com.tienda.mayorista.persistence.crud;


import com.tienda.mayorista.persistence.entity.Proveedor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorCrudRepository extends CrudRepository<Proveedor, Integer> {

    Optional<Proveedor> findByRuc(String ruc);
}
