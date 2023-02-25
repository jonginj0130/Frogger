package com.example.cs2340project;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Display;
public class Frog {

    Context context;
    Bitmap frog;
    int posx, posy;
    int spriteColor, width, height;
    Display display;

    public Frog(int spriteColor, Context context) {
        this.context = context;
        this.spriteColor = spriteColor; // R.drawable.x is an ID that is an Integer Type
        this.frog = BitmapFactory.decodeResource(context.getResources(), spriteColor);
        this.height = (int) (GameView.screenHeight * 0.075); //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * 0.075); // should be the same as height as it should be a square

        this.posx = GameView.screenWidth / 2;
        this.posy = GameView.screenHeight - this.height - 1;
    }

    public Bitmap getFrog() {
        return frog;
    }


}