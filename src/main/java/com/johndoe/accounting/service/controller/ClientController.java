package com.johndoe.accounting.service.controller;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.request.ClientRequest;
import com.johndoe.accounting.service.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nebil on 12/1/18.
 */
@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("")
    public void addClient(@RequestBody ClientRequest clientRequest)throws InvalidClientInputException{
        clientService.addclient(clientRequest);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable long id)throws Exception{
        return clientService.getClientById(id);
    }

    @GetMapping("type/{type}")
    public List<Client> getAllClientsByType(@PathVariable(value = "type") Type type){
        return clientService.getAllClientsByType(type);
    }

    @GetMapping("")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")
    public void updateClient(@RequestBody ClientRequest clientRequest, @PathVariable long id)throws InvalidClientInputException{
        clientService.updateClient(clientRequest, id);
    }
}
