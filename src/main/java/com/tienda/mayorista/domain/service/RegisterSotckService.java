package com.tienda.mayorista.domain.service;

import com.tienda.mayorista.domain.RegisterStock;
import com.tienda.mayorista.domain.repository.RegisterStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterSotckService {

    @Autowired
    private RegisterStockRepository registerStockRepository;

    public List<RegisterStock> getAll(){
        return registerStockRepository.getAll();
    }

    public Optional<RegisterStock> getRegisterStock(int registerStockId){
        return registerStockRepository.getRegisterStock(registerStockId);
    }

    public Optional<List<RegisterStock>> getByProduct(int productId){
        return registerStockRepository.getByProduct(productId);
    }

    public RegisterStock save(RegisterStock registerStock){
        return registerStockRepository.save(registerStock);
    }

    public boolean delete(int registerStockId) {
        return getRegisterStock(registerStockId).map(register -> {
            registerStockRepository.delete(registerStockId);
            return true;
        }).orElse(false);
    }

}
