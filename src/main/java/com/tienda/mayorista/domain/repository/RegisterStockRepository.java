package com.tienda.mayorista.domain.repository;


import com.tienda.mayorista.domain.RegisterStock;

import java.util.List;
import java.util.Optional;

public interface RegisterStockRepository {

    List<RegisterStock> getAll();
    Optional<List<RegisterStock>> getByProduct(int productId);
    Optional<List<RegisterStock>> getScarseProduct(int quantity);
    Optional<RegisterStock> getRegisterStock(int registerStockId);
    RegisterStock save(RegisterStock registerStock);
    void delete(int registerStockId);
}
