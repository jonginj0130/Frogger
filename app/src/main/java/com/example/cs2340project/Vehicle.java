package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Vehicle {
    protected int speed;

    protected Context context;

    protected int width;
    protected int height;

    protected int lifeHeight;

    protected float posx;
    protected float posy;
    protected Bitmap vehicle;


    Vehicle(Context context, int vehicleType, int width,
             int height, float posx, float posy, int speed) {

        this.context = context;
        this.vehicle = BitmapFactory.decodeResource(context.getResources(), vehicleType);
        this.height = height; //should be 0.075 * total screenHeight
        this.width = width;
        this.vehicle = Bitmap.createScaledBitmap(vehicle, width, height, false);
        this.posx = posx; // either 0 or GameView.screenWidth - width;
        // row 0 ~ row 4. From top to bottom
        this.posy = posy;
        this.speed = speed;
        // (float) ((GameView.screenHeight * 0.0714 * (9 - row)) + lifeHeight);
    }

    public Bitmap getVehicle() {
        return vehicle;
    }

    // for testing purpose
    Vehicle(double screenWidthRatio, double screenHeightRatio, float lifeHeight, int speed) {

        this.height = (int) (GameView.screenWidth * screenHeightRatio);
        //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio);
        // should be the same as height as it should be a square
        this.lifeHeight = (int) lifeHeight;
        this.speed = speed;
        this.posx = 0;
        this.posy = (float) ((GameView.screenHeight * 0.0714 * 9) + lifeHeight);
    }


}