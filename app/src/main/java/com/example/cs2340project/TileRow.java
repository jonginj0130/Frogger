package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class TileRow {
    private int numTiles;
    private int tileSize;
    private boolean isSafe;
    private Bitmap tile;
    private Bitmap tileRow;

    public TileRow(Context context, int resource, int screenHeight, int screenWidth, boolean isSafe) {
        this.tileSize = (int) Math.round(0.075 * screenHeight);
        this.numTiles = (int) Math.ceil((float) screenWidth / tileSize);
        this.isSafe = isSafe;
        this.tile = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),
                resource), tileSize, tileSize, false);

        Bitmap merged = Bitmap.createBitmap(screenWidth, tileSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(merged);
                                                                      
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(tile, i * tileSize, 0, null);
        }
        this.tileRow = merged;
    }

    public boolean getIsSafe() {
        return isSafe;
    }

    public Bitmap getTileRow() {
        return tileRow;
    }
}
