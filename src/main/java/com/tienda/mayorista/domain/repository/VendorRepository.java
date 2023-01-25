package com.tienda.mayorista.domain.repository;

import com.tienda.mayorista.domain.Vendor;

import java.util.List;
import java.util.Optional;

public interface VendorRepository {

    List<Vendor> getAll();
    Optional<Vendor> getVendor(int vendorId);
    Optional<Vendor> getByRuc(String ruc);
    Vendor save(Vendor vendor);
    void delete(int vendorId);
}
