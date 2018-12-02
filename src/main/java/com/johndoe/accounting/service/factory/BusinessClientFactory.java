package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.model.Business;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.request.ClientRequest;
import com.johndoe.accounting.service.validator.ClientValidator;

/**
 * Created by nebil on 11/30/18.
 */
public class BusinessClientFactory extends ClientFactory {

    @Override
    public Client createClient(ClientRequest clientRequest) throws InvalidClientInputException{
        ClientValidator clientValidator = new ClientValidator(clientRequest);

        Business business = new Business();
        business.setType(Type.Business);
        clientValidator.validate();
        business.setId(clientRequest.getId());
        business.setBusinessName(clientRequest.getBusinessName());
        business.setNumberOfEmployee(clientRequest.getNumberOfEmployee());
        business.setLocation(clientRequest.getLocation());

        return business;
    }
}
