package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.model.Client;
import com.johndoe.accounting.service.model.Individual;
import com.johndoe.accounting.service.request.ClientRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nebil on 12/2/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class IndividualClientFactoryTest {
    @Mock
    private ClientRequest clientRequest;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private IndividualClientFactory individualClientFactory;


    @Before
    public void setUp() throws Exception {
        when(clientRequest.getType()).thenReturn(String.valueOf(Type.Individual));
        when(clientRequest.getFirstName()).thenReturn("Aman");
        when(clientRequest.getLastName()).thenReturn("Samuel");
        when(clientRequest.getBirthDate()).thenReturn(LocalDate.of(1999, 12,12));
        when(clientRequest.getId()).thenReturn(2L);
        when(clientRequest.getTitle()).thenReturn("Engineer");
        individualClientFactory = new IndividualClientFactory();

    }

    @Test
    public void whenCreateClientIsCalledIndividualClientGetsCreated() throws Exception {
        Individual individualClient = (Individual) individualClientFactory.createClient(clientRequest);
        assertEquals("Aman", individualClient.getFirstName());
        assertEquals("Samuel", individualClient.getLastName());
        assertEquals("Engineer", individualClient.getTitle());

        verify(clientRequest, times(2)).getFirstName();
        verify(clientRequest, times(2)).getLastName();
        verify(clientRequest, times(3)).getBirthDate();
        verify(clientRequest, times(3)).getType();
        verify(clientRequest, times(1)).getTitle();
    }

    @Test
    public void whenCreateClientIsCalledExceptionWillBeThrown()throws InvalidClientInputException{

        when(clientRequest.getBirthDate()).thenReturn(LocalDate.of(2000, 12,12));
        expectedException.expect(InvalidClientInputException.class);
        expectedException.expectMessage("Person is underage!");
        individualClientFactory.createClient(clientRequest);

        verify(clientRequest, times(1)).getFirstName();
        verify(clientRequest, times(1)).getLastName();
        verify(clientRequest, times(1)).getBirthDate();
        verify(clientRequest, times(1)).getType();
        verify(clientRequest, times(1)).getTitle();
    }



}