package com.example.cs2340project;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VehicleTest {

    @Test
    public void speedTest() {
        Vehicle vehicle = new Vehicle(GameView.screenWidthRatio, GameView.screenHeightRatio, (float) (GameView.screenHeight * 0.05), 20);
        assertEquals((vehicle.speed), 20);
    }
    @Test
    public void heightTest() {
        Vehicle vehicle = new Vehicle(GameView.screenWidthRatio, GameView.screenHeightRatio, (float) (GameView.screenHeight * 0.05), 20);
        assertEquals((vehicle.height), (int) (GameView.screenHeight * GameView.screenHeightRatio));
    }
    @Test
    public void WidthTest() {
        // Context of the app under test.
        Vehicle vehicle = new Vehicle(GameView.screenWidthRatio, GameView.screenHeightRatio, (float) (GameView.screenHeight * 0.05), 20);
        assertEquals((vehicle.width), (int) (GameView.screenWidth * 0.143));
    }

    @Test
    public void Position() {
        // Context of the app under test.
        Vehicle vehicle = new Vehicle(GameView.screenWidthRatio, GameView.screenHeightRatio, (float) (GameView.screenHeight * 0.05), 20);
        assertEquals((int) (vehicle.posx), 0);
    }

}
