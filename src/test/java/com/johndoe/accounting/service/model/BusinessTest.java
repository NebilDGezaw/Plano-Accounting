package com.johndoe.accounting.service.model;

import com.johndoe.accounting.service.clientType.Type;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by nebil on 11/30/18.
 */
@RunWith(MockitoJUnitRunner.class)
public class BusinessTest {
    @Mock
    Location location;
    Business business;
    @Before
    public void setUp() throws Exception {
        when(location.getState()).thenReturn("TX");
        when(location.getCity()).thenReturn("Plano");
        when(location.getZipCode()).thenReturn(75025);
        when(location.getAddress()).thenReturn("address 123");

        business = new Business();
        business.setId(21);
        business.setBusinessName("AAA");
        business.setNumberOfEmployee(45);
        business.setType(Type.Business);
        business.setLocation(location);
    }

    @Test
    public void getBusinessName() throws Exception {
        assertEquals("AAA", business.getBusinessName());
    }

    @Test
    public void getNumberOfEmployee() throws Exception {
        assertEquals(45, business.getNumberOfEmployee());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(21l, business.getId());
    }

    @Test
    public void getType() throws Exception {
        assertEquals("Business", business.getType());
    }

    @Test
    public void getLocation(){
        assertEquals("TX", business.getLocation().getState());
        assertEquals("Plano", business.getLocation().getCity());
        assertEquals(75025, business.getLocation().getZipCode());
        assertEquals("address 123", business.getLocation().getAddress());
        verify(location, times(1)).getState();
        verify(location, times(1)).getCity();
        verify(location, times(1)).getAddress();
        verify(location, times(1)).getZipCode();
    }

}