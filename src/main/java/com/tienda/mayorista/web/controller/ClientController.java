package com.tienda.mayorista.web.controller;


import com.tienda.mayorista.domain.Client;
import com.tienda.mayorista.domain.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getCliente(@PathVariable("id") int clientId){
        return clientService.getCliente(clientId)
                .map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<>(clientService.save(client), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int clientId){
        if (clientService.delete(clientId)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
