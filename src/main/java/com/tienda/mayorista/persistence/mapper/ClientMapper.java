package com.tienda.mayorista.persistence.mapper;

import com.tienda.mayorista.domain.Client;
import com.tienda.mayorista.persistence.entity.Cliente;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "direccion", target = "adress"),
            @Mapping(source = "telefono", target = "phone"),
            @Mapping(source = "dni", target = "dni"),
    })
    Client toClient(Cliente cliente);
    List<Client> toClients(List<Cliente> clientes);

    @InheritInverseConfiguration
    @Mapping(target = "facturas", ignore = true)
    Cliente toCliente(Client client);
}
