package com.tienda.mayorista.domain.repository;

import com.tienda.mayorista.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();
    Optional<Client> getCliente(int clientId);
    Client save(Client client);
    void delete(int clientId);
}
