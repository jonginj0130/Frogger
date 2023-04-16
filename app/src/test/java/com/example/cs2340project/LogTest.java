package com.example.cs2340project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LogTest {

    int tileWidth = (int) (GameView.screenWidth * GameView.screenWidthRatio);
    int tileHeight = (int) (GameView.screenHeight * GameView.screenHeightRatio);
    Log log = new Log(50, 50, tileWidth, tileHeight, 20);
    Frog frog = new Frog(0, GameView.screenWidthRatio, GameView.screenHeightRatio);

    @Test
    public void speedTest() {
        assertEquals((log.speed), 20);
    }
    @Test
    public void heightTest() {
        assertEquals((log.height), tileHeight);
    }
    @Test
    public void widthTest() {
        // Context of the app under test.
        assertEquals((log.width), tileWidth);
    }
    @Test
    public void positionTest() {
        assertEquals((int) (log.posx), 50);
    }

    @Test
    public void collisionWithFrogTest() {
        assertEquals(log.posx + log.width >= frog.posx &&
                log.posx <= frog.posx + frog.width &&
                log.posy + log.height >= frog.posy &&
                log.posy <= frog.posy + frog.height, false);
    }


}
