package com.johndoe.accounting.service.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by nebil on 11/30/18.
 */
public class LocationTest {
    Location location;
    @Before
    public void setUp() throws Exception {
        location = new Location();
        location.setAddress("123 address");
        location.setCity("plano");
        location.setState("TX");
        location.setZipCode(75074);
        location.setId(3L);
    }

    @Test
    public void getState() throws Exception {
        assertEquals("TX", location.getState());
    }

    @Test
    public void getCity() throws Exception {
        assertEquals("plano", location.getCity());
    }

    @Test
    public void getZipCode() throws Exception {
        assertEquals(75074, location.getZipCode());
    }

    @Test
    public void getAddress() throws Exception {
        assertEquals("123 address", location.getAddress());
    }

    @Test
    public void getId() throws Exception {
        assertEquals(3, location.getId());
    }

}