package com.tienda.mayorista.persistence.crud;


import com.tienda.mayorista.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteCrudRepository extends CrudRepository<Cliente, Integer> {

    List<Cliente> findByIdCliente(int idCliente);

}
