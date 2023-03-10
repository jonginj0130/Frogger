package com.example.cs2340project;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Vehicle {
    int speed = 20;

    Context context;

    int width, height;

    int lifeHeight;

    float posx1, posy1, posx2, posy2, posx3, posy3, posx4, posy4;
    Bitmap vehicle1;
    Bitmap vehicle2;
    Bitmap vehicle3;



    public Bitmap getVehicle1() {
        return vehicle1;
    }

    public Bitmap getVehicle2() {
        return vehicle2;
    }

    public Bitmap getVehicle3() {
        return vehicle3;
    }

    public Bitmap getVehicle4() {
        return vehicle4;
    }

    Bitmap vehicle4;

    Vehicle (Context context, double screenWidthRatio, double screenHeightRatio, int lifeHeight) {

        this.context = context;
        this.vehicle1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.police_car);
        this.vehicle2 = BitmapFactory.decodeResource(context.getResources(), R.drawable.police_car);
        this.vehicle3 = BitmapFactory.decodeResource(context.getResources(), R.drawable.red_car);
        this.vehicle4 = BitmapFactory.decodeResource(context.getResources(), R.drawable.red_car);
        this.height = (int) (GameView.screenWidth * screenWidthRatio); //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio); // should be the same as height as it should be a square
        this.vehicle1 = Bitmap.createScaledBitmap(vehicle1, width, height, false);
        this.vehicle2 = Bitmap.createScaledBitmap(vehicle2, width * 2, height, false);
        this.vehicle3 = Bitmap.createScaledBitmap(vehicle3, width, height, false);
        this.vehicle4 = Bitmap.createScaledBitmap(vehicle4, width * 2, height, false);
        this.lifeHeight = lifeHeight;


        this.posx1 = 0;
        this.posy1 = (float) ((GameView.screenHeight * 0.0714 * 9) + lifeHeight);
        this.posx2 = GameView.screenWidth - width;
        this.posy2 = (float) ((GameView.screenHeight * 0.0714 * 8) + lifeHeight);
        this.posx3 = 0;
        this.posy3 = (float) ((GameView.screenHeight * 0.0714 * 7) + lifeHeight);
        this.posx4 = GameView.screenWidth - width;
        this.posy4 = (float) ((GameView.screenHeight * 0.0714 * 6) + lifeHeight);
    }

    Vehicle (double screenWidthRatio, double screenHeightRatio, float lifeHeight) {

        this.height = (int) (GameView.screenWidth * screenWidthRatio); //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio); // should be the same as height as it should be a square
        this.lifeHeight = (int) lifeHeight;

        this.posx1 = 0;
        this.posy1 = (float) ((GameView.screenHeight * 0.0714 * 9) + lifeHeight);
        this.posx2 = GameView.screenWidth - width;
        this.posy2 = (float) ((GameView.screenHeight * 0.0714 * 8) + lifeHeight);
        this.posx3 = 0;
        this.posy3 = (float) ((GameView.screenHeight * 0.0714 * 7) + lifeHeight);
        this.posx4 = GameView.screenWidth - width;
        this.posy4 = (float) ((GameView.screenHeight * 0.0714 * 6) + lifeHeight);
    }

}
