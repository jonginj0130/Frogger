package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class TileRow {
    private int numTiles;
    private boolean isSafe;
    private Bitmap tile;
    private Bitmap tileRow;

    public TileRow(Context context, int size, int resource, int screenWidth, boolean isSafe) {
        this.numTiles = (int) Math.ceil((float) screenWidth / size);
        this.isSafe = isSafe;

        this.tile = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(context.getResources(),
                resource), size, size, false);

        Bitmap merged = Bitmap.createBitmap(screenWidth, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(merged);
                                                                      
        for (int i = 0; i <= numTiles; i++) {

            canvas.drawBitmap(tile, i * size, 0, null);
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
