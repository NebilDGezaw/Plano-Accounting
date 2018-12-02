package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.model.Business;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.request.ClientRequest;

/**
 * Created by nebil on 11/30/18.
 */
public class BusinessClientFactory extends ClientFactory {

    @Override
    public Client createClient(ClientRequest clientRequest) {

        Business business = new Business();
        business.setId(clientRequest.getId());
        business.setBusinessName(clientRequest.getBusinessName());
        business.setNumberOfEmployee(clientRequest.getNumberOfEmployee());
        business.setType(Type.Business);
        business.setLocation(clientRequest.getLocation());
        return business;
    }
}
