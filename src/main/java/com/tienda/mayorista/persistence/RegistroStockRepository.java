package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.RegisterStock;
import com.tienda.mayorista.domain.repository.RegisterStockRepository;
import com.tienda.mayorista.persistence.crud.RegistroStockCrudRepository;
import com.tienda.mayorista.persistence.entity.RegistroStock;
import com.tienda.mayorista.persistence.mapper.RegisterStockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RegistroStockRepository implements RegisterStockRepository {

    @Autowired
    private RegistroStockCrudRepository registroStockCrudRepository;

    @Autowired
    private RegisterStockMapper mapper;

    @Override
    public List<RegisterStock> getAll(){
        List<RegistroStock> registroStocks = (List<RegistroStock>) registroStockCrudRepository.findAll();
        return mapper.toRegisterStocks(registroStocks);
    }

    @Override
    public Optional<List<RegisterStock>> getByProduct(int productId) {
        List<RegistroStock> registroStocks = registroStockCrudRepository.findByIdProducto(productId);
        return Optional.of(mapper.toRegisterStocks(registroStocks));
    }

    @Override
    public Optional<List<RegisterStock>> getScarseProduct(int quantity) {
        Optional<List<RegistroStock>> registroStocks = registroStockCrudRepository.findByCantidadLessThan(quantity);
        return registroStocks.map(registros -> mapper.toRegisterStocks(registros));
    }

    @Override
    public Optional<RegisterStock> getRegisterStock(int registerStockId) {
        return registroStockCrudRepository.findById(registerStockId).map(registro -> mapper.toRegisterStock(registro));
    }

    @Override
    public RegisterStock save(RegisterStock registerStock) {
        RegistroStock registroStock = mapper.toRegistroStock(registerStock);
        return mapper.toRegisterStock(registroStockCrudRepository.save(registroStock));
    }


    @Override
    public void delete(int idRegStock) {
        registroStockCrudRepository.deleteById(idRegStock);
    }
}
