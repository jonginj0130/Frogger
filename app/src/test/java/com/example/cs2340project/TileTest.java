package com.example.cs2340project;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Test;

public class TileTest {

    Tile river = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.river, false);
    Tile goal = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.gold, true);
    Tile safe = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.grass, true);
    Tile road = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.road, true);


    @Test
    public void tileIDMatch() {
        assertEquals(river.tileID, R.drawable.river);
        assertEquals(goal.tileID, R.drawable.gold);
        assertEquals(safe.tileID, R.drawable.grass);
        assertEquals(road.tileID, R.drawable.road);
    }

    @Test
    public void tileIsSafe() {
        assertEquals(river.isSafe, false);
        assertEquals(goal.isSafe, true);
        assertEquals(safe.isSafe, true);
        assertEquals(road.isSafe, true);
    }
}