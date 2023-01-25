package com.tienda.mayorista.persistence.crud;

import com.tienda.mayorista.persistence.entity.RegistroStock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RegistroStockCrudRepository extends CrudRepository<RegistroStock, Integer > {

//    @Query(value = "SELECT * FROM registros_stock WHERE id_producto = ?", nativeQuery = true)
    List<RegistroStock> findByIdProducto(int idProducto);

    Optional<List<RegistroStock>> findByCantidadLessThan(int cantidad);
}
