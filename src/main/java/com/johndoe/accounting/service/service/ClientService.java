package com.johndoe.accounting.service.service;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.factory.ClientFactory;
import com.johndoe.accounting.service.factory.ClientFactoryProducer;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.model.Location;
import com.johndoe.accounting.service.repository.ClientRepository;
import com.johndoe.accounting.service.repository.LocationRepository;
import com.johndoe.accounting.service.request.ClientRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nebil on 12/1/18.
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LocationRepository locationRepository;


    public void addclient(ClientRequest clientRequest)throws InvalidClientInputException{
        ClientFactoryProducer clientFactoryProducer = new ClientFactoryProducer();
        ClientFactory clientFactory = clientFactoryProducer.createFactory(Type.valueOf(clientRequest.getType()));
        Client client = clientFactory.createClient(clientRequest);
        clientRepository.save(client);

        Location location = clientRequest.getLocation();
        location.setClient(client);
        locationRepository.save(location);
    }

    public Client getClientById(long id)throws Exception{
        return clientRepository.findById(id).orElseThrow(()-> new Exception());
    }

    public List<Client> getAllClientsByType(Type type){
        return clientRepository.findByType(type);
    }

    public List<Client> getAllClients(){
        return (List<Client>)clientRepository.findAll();
    }

    public void updateClient(ClientRequest clientRequest, long id)throws InvalidClientInputException{
        clientRequest.setId(id);
        ClientFactoryProducer clientFactoryProducer = new ClientFactoryProducer();
        ClientFactory clientFactory = clientFactoryProducer.createFactory(Type.valueOf(clientRequest.getType()));
        Client client = clientFactory.createClient(clientRequest);
        client.setId(id);
        clientRepository.save(client);


    }

    public void deleteClient(long id){
        clientRepository.deleteById(id);
    }
}
