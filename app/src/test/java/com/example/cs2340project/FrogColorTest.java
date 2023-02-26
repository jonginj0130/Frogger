package com.example.cs2340project;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


// JUNIT TEST BY TAEYUN LEE
public class FrogColorTest {

    @Test
    public void ColorTest() {
        // Context of the app under test.
        Frog frog = new Frog(0, GameView.screenWidthRatio, GameView.screenHeightRatio);
        assertEquals("green", frog.color);
    }
}
