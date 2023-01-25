package com.tienda.mayorista.domain.service;

import com.tienda.mayorista.domain.Vendor;
import com.tienda.mayorista.domain.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    public List<Vendor> getAll(){
        return vendorRepository.getAll();
    }

    public Optional<Vendor> getVendor(int vendorId){
        return vendorRepository.getVendor(vendorId);
    }

    public Optional<Vendor> getByRuc(String ruc){
        return vendorRepository.getByRuc(ruc);
    }

    public Vendor save(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public boolean delete(int vendorId){
        return getVendor(vendorId).map(vendor -> {
            vendorRepository.delete(vendorId);
            return true;
        }).orElse(false);
    }
}
