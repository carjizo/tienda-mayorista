package com.tienda.mayorista.domain.repository;

import com.tienda.mayorista.domain.Bill;

import java.util.List;
import java.util.Optional;

public interface BillRepository {

    List<Bill> getAll();
    Optional<List<Bill>> getByClient(int clientId);
    Optional<List<Bill>> getByVendor(int vendorId);
    Optional<List<Bill>> getByBillNumber(int billNumber);
    Optional<Bill> getBill(int billId);
    Bill save(Bill bill);
    void delete(int billId);
}
