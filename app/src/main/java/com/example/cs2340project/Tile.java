package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.view.Display;

public class Tile {
    Context context;
    Bitmap tile;
    int width, height;
    int tileID;
    boolean isSafe;

    public Tile(Context context, int width, int height, int tileID, boolean isSafe) {
        this.context = context;
        this.width = width;
        this.height = height;
        this.tileID = tileID;
        this.tile = BitmapFactory.decodeResource(context.getResources(), tileID);
        this.tile = Bitmap.createScaledBitmap(this.tile, width, height, false);
        this.isSafe = isSafe;
    }

    // for testing purpose
    public Tile(int width, int height, int tileID, boolean isSafe) {
        this.width = width;
        this.height = height;
        this.isSafe = isSafe;
        this.tileID = tileID;
    }

    public Bitmap getTile() {
        return tile;
    }

}
