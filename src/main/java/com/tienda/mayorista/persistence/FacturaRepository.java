package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.Bill;
import com.tienda.mayorista.domain.repository.BillRepository;
import com.tienda.mayorista.persistence.crud.FacturaCrudRepository;
import com.tienda.mayorista.persistence.entity.Factura;
import com.tienda.mayorista.persistence.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FacturaRepository implements BillRepository {

    @Autowired
    private FacturaCrudRepository facturaCrudRepository;

    @Autowired
    private BillMapper mapper;

    @Override
    public List<Bill> getAll(){
        List<Factura> facturas = (List<Factura>) facturaCrudRepository.findAll();
        return mapper.toBills(facturas);
    }

    @Override
    public Optional<List<Bill>> getByClient(int clientId) {
        Optional<List<Factura>> facturas = facturaCrudRepository.findByIdCliente(clientId);
        return facturas.map(facturas1 -> mapper.toBills(facturas1));
    }

    @Override
    public Optional<List<Bill>> getByVendor(int vendorId) {
        Optional<List<Factura>> facturas = facturaCrudRepository.findByIdProveedor(vendorId);
        return facturas.map(facturas1 -> mapper.toBills(facturas1));
    }

    @Override
    public Optional<List<Bill>> getByBillNumber(int billNumber) {
        Optional<List<Factura>> facturas = facturaCrudRepository.findByNumeroFactura(billNumber);
        return facturas.map(facturas1 -> mapper.toBills(facturas1));
    }

    @Override
    public Optional<Bill> getBill(int billId) {
        return facturaCrudRepository.findById(billId).map(factura -> mapper.toBill(factura));
    }

    @Override
    public Bill save(Bill bill) {
        Factura factura = mapper.toFactura(bill);
        return mapper.toBill(facturaCrudRepository.save(factura));
    }

    @Override
    public void delete(int idFactura){
        facturaCrudRepository.deleteById(idFactura);
    }
}
