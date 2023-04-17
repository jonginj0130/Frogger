package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Log {
    protected int speed;

    protected Context context;

    protected int width;
    protected int height;
    protected float posx;
    protected float posy;

    protected Bitmap log;

    Log(Context context, int vehicleType, int width,
        int height, float posx, float posy, int speed) {
        this.context = context;
        this.log = BitmapFactory.decodeResource(context.getResources(), vehicleType);
        this.height = height; //should be 0.075 * total screenHeight
        this.width = width;
        this.log = Bitmap.createScaledBitmap(log, width, height, false);
        this.posx = posx; // either 0 or GameView.screenWidth - width;
        // row 0 ~ row 3. From top to bottom
        this.posy = posy;
        this.speed = speed;
        // (float) ((GameView.screenHeight * 0.0714 * (9 - row)) + lifeHeight);
    }

    public Bitmap getLog() {
        return log;
    }

    // for testing purpose
    Log(float posx, float posy, int width, int height, int speed) {
        this.posx = posx;
        this.posy = posy;
        this.height = height;
        //should be 0.075 * total screenHeight
        this.width = width;
        // should be the same as height as it should be a square
        this.speed = speed;
        this.posx = posx;
        this.posy = posy;
    }

    public Rect getRect() {
        return new Rect((int) posx, (int) posy, (int) (posx + width), (int) (posy + height));
    }

}