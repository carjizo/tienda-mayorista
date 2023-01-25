package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.Vendor;
import com.tienda.mayorista.domain.repository.VendorRepository;
import com.tienda.mayorista.persistence.crud.ProveedorCrudRepository;
import com.tienda.mayorista.persistence.entity.Proveedor;
import com.tienda.mayorista.persistence.mapper.VendorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProveedorRepository implements VendorRepository {

    @Autowired
    private ProveedorCrudRepository proveedorCrudRepository;

    @Autowired
    private VendorMapper mapper;


    @Override
    public List<Vendor> getAll(){
        List<Proveedor> proveedors = (List<Proveedor>) proveedorCrudRepository.findAll();
        return mapper.toVendors(proveedors);
    }

    @Override
    public Optional<Vendor> getVendor(int vendorId) {
        return proveedorCrudRepository
                .findById(vendorId)
                .map(proveedor -> mapper.toVendor(proveedor));
    }

    @Override
    public Optional<Vendor> getByRuc(String ruc) {
        return proveedorCrudRepository
                .findByRuc(ruc)
                .map(proveedor -> mapper.toVendor(proveedor));
    }

    @Override
    public Vendor save(Vendor vendor) {
        Proveedor proveedor  =  mapper.toProveedor(vendor);
        return mapper.toVendor(proveedorCrudRepository.save(proveedor));
    }


    @Override
    public void delete(int idCliente){
        proveedorCrudRepository.deleteById(idCliente);
    }
}
