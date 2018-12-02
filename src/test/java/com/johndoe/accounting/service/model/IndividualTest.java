package com.johndoe.accounting.service.model;

import com.johndoe.accounting.service.clientType.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nebil on 11/30/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class IndividualTest {
    @Mock
    Location location;

    Individual individual;
    @Before
    public void setUp() throws Exception {
        when(location.getState()).thenReturn("TX");
        when(location.getCity()).thenReturn("Frisco");
        when(location.getZipCode()).thenReturn(75022);
        when(location.getAddress()).thenReturn("address 123");

        individual = new Individual();
        individual.setId(13);
        individual.setType(Type.Individual);
        individual.setBirthDate(LocalDate.of(1990, 02, 03));
        individual.setTitle("Doctor");
        individual.setFirstName("House");
        individual.setLastName("Greg");
        individual.setLocation(location);
    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("House", individual.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("Greg", individual.getLastName());
    }

    @Test
    public void getBithDate() throws Exception {
        assertEquals("1990-02-03", individual.getBithDate().toString());
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("Doctor", individual.getTitle());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(13l, individual.getId());
    }

    @Test
    public void getType() throws Exception {
        assertEquals("Individual", individual.getType().toString());
    }

    @Test
    public void getLocation(){
        assertEquals("TX", individual.getLocation().getState());
        assertEquals("Frisco", individual.getLocation().getCity());
        assertEquals(75022, individual.getLocation().getZipCode());
        assertEquals("address 123", individual.getLocation().getAddress());
        verify(location, times(1)).getState();
        verify(location, times(1)).getCity();
        verify(location, times(1)).getAddress();
        verify(location, times(1)).getZipCode();
    }

}