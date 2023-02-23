package com.example.cs2340project;

import static org.junit.Assert.*;

import org.junit.Test;

// JUNIT TEST BY SAGAR SADAK
public class CustomizationScreenNullNameTest {

    @Test
    public void checkNameValidity() {
        String testString = null;
        assertFalse(CustomizationScreen.checkNameValidity(testString));
    }
}