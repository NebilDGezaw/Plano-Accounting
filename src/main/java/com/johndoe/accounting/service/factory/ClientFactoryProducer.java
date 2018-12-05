package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nebil on 11/30/18.
 */
public class ClientFactoryProducer {

    Map<Type, ClientFactory> factoryMap = new HashMap<>();
    {
        factoryMap.put(Type.Individual, new IndividualClientFactory());
        factoryMap.put(Type.Business, new BusinessClientFactory());
    }

    public ClientFactory createFactory(Type type){

        return factoryMap.get(type);
    }
}
