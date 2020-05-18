package com.tracking.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {

    private Address address;
    @Before
    public void setUp() throws Exception {
        address = new Address();
        address.setCity("Санкт-Петербург");
        address.setStreet("Стачек");
        address.setHouse("135");
        address.setFlat("31");
    }

    @Test
    public void getFullAddress() {
        String full = "г. Санкт-Петербург ул. Стачек д. 135 кв. 31";
        assertEquals(full,address.getFullAddress());
    }
}