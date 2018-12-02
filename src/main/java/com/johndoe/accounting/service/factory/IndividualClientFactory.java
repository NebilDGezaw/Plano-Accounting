package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.model.Individual;
import com.johndoe.accounting.service.request.ClientRequest;
import com.johndoe.accounting.service.validator.ClientValidator;

/**
 * Created by nebil on 11/30/18.
 */
public class IndividualClientFactory extends ClientFactory{

    @Override
    public Client createClient(ClientRequest clientRequest) throws InvalidClientInputException {
        ClientValidator clientValidator = new ClientValidator(clientRequest);

        Individual individual = new Individual();
        individual.setType(Type.Individual);
        clientValidator.validate();
        individual.setId(clientRequest.getId());
        individual.setFirstName(clientRequest.getFirstName());
        individual.setLastName(clientRequest.getLastName());
        individual.setBirthDate(clientRequest.getBirthDate());
        individual.setTitle(clientRequest.getTitle());
        individual.setLocation(clientRequest.getLocation());

        return individual;
    }
}
