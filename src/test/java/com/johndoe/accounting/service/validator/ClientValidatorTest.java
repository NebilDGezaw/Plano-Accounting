package com.johndoe.accounting.service.validator;

import com.johndoe.accounting.service.clientType.Type;
import com.johndoe.accounting.service.exceptions.InvalidClientInputException;
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
public class ClientValidatorTest {

    @Mock
    private ClientRequest clientRequest;

    private ClientValidator clientValidator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        when(clientRequest.getType()).thenReturn(String.valueOf(Type.Individual));
        when(clientRequest.getFirstName()).thenReturn("Nebil1");
        when(clientRequest.getLastName()).thenReturn("Geza w");
        when(clientRequest.getNumberOfEmployee()).thenReturn(-2);
        when(clientRequest.getBirthDate()).thenReturn(LocalDate.of(2005, 12,12));

        clientValidator = new ClientValidator(clientRequest);
    }

    @Test
    public void individualClientGetsValidatedWhenIndividualIsCalled() throws Exception {
        expectedException.expect(InvalidClientInputException.class);
        expectedException.expectMessage("Invalid input for first name" +
                System.getProperty("line.separator") + "Invalid input for last name" +
                System.getProperty("line.separator") + "Person is underage!");
        clientValidator.validate();


        verify(clientRequest, times(1)).getFirstName();
        verify(clientRequest, times(1)).getLastName();
        verify(clientRequest, times(1)).getBirthDate();
        verify(clientRequest, times(1)).getType();
        verify(clientRequest, times(0)).getNumberOfEmployee();
    }

    @Test
    public void businessClientGetsValidatedWhenBusinessIsCalled() throws Exception {
        expectedException.expect(InvalidClientInputException.class);
        expectedException.expectMessage("Number of employees can't be 0 or negative");
        when(clientRequest.getType()).thenReturn(String.valueOf(Type.Business));
        clientValidator.validate();
        verify(clientRequest, times(0)).getFirstName();
        verify(clientRequest, times(0)).getLastName();
        verify(clientRequest, times(0)).getBirthDate();
        verify(clientRequest, times(1)).getType();
        verify(clientRequest, times(1)).getNumberOfEmployee();
    }

}