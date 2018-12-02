package com.johndoe.accounting.service.model;

import com.johndoe.accounting.service.clientType.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by nebil on 11/30/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientTest {
    @Mock
    Location location;

    Client client;
    @Before
    public void setUp() throws Exception {
        client = new Client() {
            @Override
            public long getId() {
                return super.getId();
            }

            @Override
            public void setId(long id) {
                super.setId(id);
            }

            @Override
            public String getType() {
                return super.getType();
            }

            @Override
            public void setType(Type type) {
                super.setType(type);
            }

            @Override
            public void setLocation(Location location) {
                super.setLocation(location);
            }
        };
        client.setId(12);
        client.setType(Type.Business);
        when(location.getState()).thenReturn("TX");
        when(location.getCity()).thenReturn("Plano");
        when(location.getZipCode()).thenReturn(75099);
        when(location.getAddress()).thenReturn("address 123");
        client.setLocation(location);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(12l, client.getId());
    }

    @Test
    public void getType() throws Exception {
        assertEquals("Business", client.getType().toString());
    }

    @Test
    public void getLocation(){
        assertEquals("TX", client.getLocation().getState());
        assertEquals("Plano", client.getLocation().getCity());
        assertEquals(75099, client.getLocation().getZipCode());
        assertEquals("address 123", client.getLocation().getAddress());
        verify(location, times(1)).getState();
        verify(location, times(1)).getCity();
        verify(location, times(1)).getAddress();
        verify(location, times(1)).getZipCode();
    }

}