package com.example.cs2340project;

import static org.junit.Assert.*;

import org.junit.Test;

// JUNIT TEST BY SAGAR SADAK
public class CustomizationScreenWhitespaceNameTest {

    @Test
    public void checkNameValidity() {
        String testString1 = "     ";
        String testString2 = "name     ";
        String testString3 = "     name";
        String testString4 = "  name  ";
        assertFalse(CustomizationScreen.checkNameValidity(testString1));
        assertTrue(CustomizationScreen.checkNameValidity(testString2));
        assertTrue(CustomizationScreen.checkNameValidity(testString3));
        assertTrue(CustomizationScreen.checkNameValidity(testString4));
    }
}