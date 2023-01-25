package com.tienda.mayorista.persistence;

import com.tienda.mayorista.domain.Client;
import com.tienda.mayorista.domain.repository.ClientRepository;
import com.tienda.mayorista.persistence.crud.ClienteCrudRepository;
import com.tienda.mayorista.persistence.entity.Cliente;
import com.tienda.mayorista.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll(){
        List<Cliente> productos = (List<Cliente>) clienteCrudRepository.findAll();
        return mapper.toClients(productos);
    }

    @Override
    public Optional<Client> getCliente(int clientId){
        return clienteCrudRepository
                .findById(clientId)
                .map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(int idCliente){
        clienteCrudRepository.deleteById(idCliente);
    }

}
