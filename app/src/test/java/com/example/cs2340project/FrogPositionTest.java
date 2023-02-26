package com.example.cs2340project;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


// JUNIT TEST BY TAEYUN LEE

public class FrogPositionTest {

    @Test
    public void PositionTest() {
        // Context of the app under test.
        Frog frog = new Frog(0, GameView.screenWidthRatio, GameView.screenHeightRatio);
        assertEquals((int) (frog.width * 3), (int) frog.posx);
    }
}
