package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.model.Individual;
import com.johndoe.accounting.service.request.ClientRequest;

/**
 * Created by nebil on 11/30/18.
 */
public class IndividualClientFactory extends ClientFactory{

    @Override
    public Client createClient(ClientRequest clientRequest) {

        Individual individual = new Individual();
        individual.setId(clientRequest.getId());
        individual.setFirstName(clientRequest.getFirstName());
        individual.setLastName(clientRequest.getLastName());
        individual.setBirthDate(clientRequest.getBirthDate());
        individual.setTitle(clientRequest.getTitle());
        individual.setType(Type.Individual);
        individual.setLocation(clientRequest.getLocation());

        return individual;
    }
}
