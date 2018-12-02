package com.johndoe.accounting.service.request;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.model.Location;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by nebil on 12/2/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class ClientRequestTest {

    @Mock
    private Location location;

    private ClientRequest clientRequest;
    @Before
    public void setUp() throws Exception {

        when(location.getCity()).thenReturn("Allen");

        clientRequest = new ClientRequest();
        clientRequest.setId(2L);
        clientRequest.setNumberOfEmployee(12);
        clientRequest.setType(Type.Individual);
        clientRequest.setBirthDate(LocalDate.of(1990, 12,12));
        clientRequest.setFirstName("Joe");
        clientRequest.setLastName("John");
        clientRequest.setLocation(location);
        clientRequest.setTitle("agent");
        clientRequest.setBusinessName("abc");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(2, clientRequest.getId());
    }

    @Test
    public void getType() throws Exception {
        assertEquals("Individual", clientRequest.getType());
    }

    @Test
    public void getLocation() throws Exception {
        assertEquals("Allen", clientRequest.getLocation().getCity());
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("Joe", clientRequest.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("John", clientRequest.getLastName());
    }

    @Test
    public void getBirthDate() throws Exception {
        assertEquals("1990-12-12", clientRequest.getBirthDate().toString());
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("agent", clientRequest.getTitle());
    }

    @Test
    public void getBusinessName() throws Exception {
        assertEquals("abc", clientRequest.getBusinessName());
    }

    @Test
    public void getNumberOfEmployee() throws Exception {
        assertEquals(12, clientRequest.getNumberOfEmployee());
    }

}