package com.johndoe.accounting.service.factory;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
import com.johndoe.accounting.service.model.Business;
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
public class BusinessClientFactoryTest {
    @Mock
    private ClientRequest clientRequest;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private BusinessClientFactory businessClientFactory;

    @Before
    public void setUp() throws Exception {
        when(clientRequest.getType()).thenReturn(String.valueOf(Type.Business));
        when(clientRequest.getNumberOfEmployee()).thenReturn(100);
        when(clientRequest.getId()).thenReturn(2L);
        when(clientRequest.getBusinessName()).thenReturn("CompanyA");
        businessClientFactory = new BusinessClientFactory();
    }

    @Test
    public void createClient() throws Exception {
        Business businessClient = (Business) businessClientFactory.createClient(clientRequest);
        assertEquals(2, businessClient.getId());
        assertEquals("CompanyA", businessClient.getBusinessName());
        assertEquals(100, businessClient.getNumberOfEmployee());

        verify(clientRequest, times(2)).getNumberOfEmployee();
        verify(clientRequest, times(1)).getBusinessName();
        verify(clientRequest, times(3)).getType();
        verify(clientRequest, times(1)).getId();
    }

    @Test
    public void whenCreateClientIsCalledExceptionWillBeThrown()throws InvalidClientInputException {

        when(clientRequest.getNumberOfEmployee()).thenReturn(0);
        expectedException.expect(InvalidClientInputException.class);
        expectedException.expectMessage("Number of employees can't be 0 or negative");
        businessClientFactory.createClient(clientRequest);

        verify(clientRequest, times(1)).getNumberOfEmployee();
        verify(clientRequest, times(1)).getBusinessName();
        verify(clientRequest, times(1)).getType();
        verify(clientRequest, times(1)).getId();
    }

}