package com.tienda.mayorista.domain.service;

import com.tienda.mayorista.domain.Bill;
import com.tienda.mayorista.domain.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public List<Bill> getAll(){
        return billRepository.getAll();
    }

    public Optional<List<Bill>> getByClient(int clientId){
        return billRepository.getByClient(clientId);
    }

    public Optional<List<Bill>> getByVendor(int vendorId){
        return billRepository.getByVendor(vendorId);
    }

    public Optional<List<Bill>> getByBillNumber(int billNumber){
        return billRepository.getByBillNumber(billNumber);
    }

    public Optional<Bill> getBill(int billId){
        return billRepository.getBill(billId);
    }

    public Bill save(Bill bill){
        return billRepository.save(bill);
    }

    public boolean delete(int billId){
        return getBill(billId).map(bill -> {
            billRepository.delete(billId);
            return true;
        }).orElse(false);
    }
}
