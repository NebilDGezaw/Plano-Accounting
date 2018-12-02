package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.request.ClientRequest;

/**
 * Created by nebil on 11/30/18.
 */
public abstract class ClientFactory {

    public abstract Client createClient(ClientRequest clientRequest);

}
