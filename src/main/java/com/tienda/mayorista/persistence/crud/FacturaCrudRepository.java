package com.tienda.mayorista.persistence.crud;

import com.tienda.mayorista.persistence.entity.Factura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacturaCrudRepository extends CrudRepository<Factura, Integer> {

    Optional<List<Factura>> findByIdCliente(int idCliente);

    Optional<List<Factura>> findByIdProveedor(int idProveedor);

    Optional<List<Factura>> findByNumeroFactura(int numeroFactura);
}
