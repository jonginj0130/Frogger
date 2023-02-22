package com.example.cs2340project;

import static org.junit.Assert.*;

import org.junit.Test;

// JUNIT TEST BY SAGAR SADAK
public class CustomizationScreenWhitespaceNameTest {

    @Test
    public void checkNameValidity() {
        String testString = "     ";
        assertFalse(CustomizationScreen.checkNameValidity(testString));
    }
}