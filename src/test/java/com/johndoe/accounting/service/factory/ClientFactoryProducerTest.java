package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nebil on 12/2/18.
 */
public class ClientFactoryProducerTest {

    private ClientFactoryProducer clientFactoryProducer;
    @Before
    public void setUp() throws Exception {
        clientFactoryProducer = new ClientFactoryProducer();

    }

    @Test
    public void createFactory() throws Exception {
        assertTrue(clientFactoryProducer.createFactory(Type.Individual) instanceof IndividualClientFactory);
    }

}