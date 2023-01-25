package com.tienda.mayorista.domain.service;

import com.tienda.mayorista.domain.Client;
import com.tienda.mayorista.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getCliente(int clientId){
        return clientRepository.getCliente(clientId);
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

    public boolean delete(int clientId){
        return getCliente(clientId).map(client -> {
            clientRepository.delete(clientId);
            return true;
        }).orElse(false);
    }
}
