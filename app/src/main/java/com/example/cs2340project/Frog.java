package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import java.util.HashMap;

public class Frog {

    protected Context context;
    protected Bitmap frog;
    protected int posx;
    protected int posy;
    protected int spriteColor;

    protected int width;
    protected int height;

    protected String color;

    protected Log playerLog;

    public Frog(int spriteColor, Context context,
                double screenWidthRatio, double screenHeightRatio) {
        this.context = context;
        this.spriteColor = spriteColor;
        // R.drawable.x is an ID that is an Integer Type
        this.frog = BitmapFactory.decodeResource(context.getResources(), spriteColor);
        this.height = (int) (GameView.screenWidth * screenWidthRatio);
        //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio);
        // should be the same as height as it should be a square
        this.frog = Bitmap.createScaledBitmap(frog, width, height, false);
        this.posx = 3 * width;
        this.posy = (int) (GameView.screenHeight * 0.05
                + GameView.screenHeight * screenHeightRatio * 12 - height);
    }

    //for testing purposes
    public Frog(int spriteColor, double screenWidthRatio, double screenHeightRatio) {
        this.context = context;
        this.spriteColor = spriteColor;
        switch (spriteColor) {
        case 0:
            color = "green";
            break;
        case 1:
            color = "blue";
            break;
        case 2:
            color = "red";
            break;
        default:
            break;
        }
        this.height = (int) (GameView.screenWidth * screenWidthRatio);
        //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio);
        // should be the same as height as it should be a square
        this.posx = 3 * width;
        this.posy = (int) (GameView.screenHeight * 0.05
                + GameView.screenHeight * screenHeightRatio * 12 - height);
    }

    public Bitmap getFrog() {
        return frog;
    }
    public Rect getRect() {
        return new Rect(posx, posy, posx + width, posy + height);
    }

    public Rect getCollision () {
        return new Rect((int) posx, (int) posy, (int) (posx + width), (int) (posy + height));
    }

    public boolean collideWithVehicle(Vehicle vehicle) {
        return Rect.intersects(this.getRect(), vehicle.getRect());
    }

    public boolean onLog(HashMap<Rect, Log> logLocations) {
        for (Rect logRect : logLocations.keySet()) {
            if (Rect.intersects(this.getRect(), logRect)) {
                playerLog = logLocations.get(logRect);
                return true;
            }
        }
        playerLog = null;
        return false;
    }

    public boolean onRiver(Rect riverRect) {
        return Rect.intersects(riverRect, this.getRect());
    }
}