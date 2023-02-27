package com.example.cs2340project;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.junit.Test;

// Tests By Trent Conley

public class MoreTileTest {

    Tile river = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.river, false);
    Tile goal = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.gold, true);
    Tile safe = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.grass, true);
    Tile road = new Tile(GameView.screenWidth, GameView.screenHeight, R.drawable.road, true);


    @Test
    public void tileWidthMatch() {
        assertEquals(river.width, GameView.screenWidth);
        assertEquals(goal.width, GameView.screenWidth);
        assertEquals(safe.width, GameView.screenWidth);
        assertEquals(road.width, GameView.screenWidth);
    }

    @Test
    public void tileHeightMatch() {
        assertEquals(river.height, GameView.screenHeight);
        assertEquals(goal.height, GameView.screenHeight);
        assertEquals(safe.height, GameView.screenHeight);
        assertEquals(road.height, GameView.screenHeight);
    }
}