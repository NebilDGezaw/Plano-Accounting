package com.johndoe.accounting.service.controller;

import com.johndoe.accounting.service.clientType.Type;
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

    @PostMapping("/add")
    public void addClient(@RequestBody ClientRequest clientRequest){
        clientService.addclient(clientRequest);
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable long id)throws Exception{
        return clientService.getClientById(id);
    }

    @GetMapping("/type/{type}")//url needs to be fixed
    public List<Client> getAllClientsByType(@PathVariable(value = "type") Type type){
        return clientService.getAllClientsByType(type);
    }

    @GetMapping("/getall")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/update/{id}")
    public void updateClient(@RequestBody ClientRequest clientRequest, @PathVariable long id){
        clientService.updateClient(clientRequest, id);
    }
}
