package com.johndoe.accounting.service.service;

import com.johndoe.accounting.service.clientType.Type;
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


    public void addclient(ClientRequest clientRequest){
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
        List<Client> clients = new ArrayList<>();
        for(Client client: clientRepository.findByType(type)){
            clients.add(client);
        }

        return clients;
    }

    public List<Client> getAllClients(){
        List<Client> clients = new ArrayList<>();

        for(Client client: clientRepository.findAll()){
            clients.add(client);
        }

        return clients;
    }

    public void updateClient(ClientRequest clientRequest, long id){
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