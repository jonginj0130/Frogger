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
<<<<<<< HEAD
=======
    Display display;
    boolean isUp = false, isDown = false, isLeft = false, isRight = false;
>>>>>>> 04ca6ade0cb747678aec2dafbf5afc29b3e8853e

    public Frog(int spriteColor, Context context, double screenWidthRatio, double screenHeightRatio) {
        this.context = context;
        this.spriteColor = spriteColor; // R.drawable.x is an ID that is an Integer Type
        this.frog = BitmapFactory.decodeResource(context.getResources(), spriteColor);
        this.height = (int) (GameView.screenWidth * screenWidthRatio); //should be 0.075 * total screenHeight
        this.width = (int) (GameView.screenWidth * screenWidthRatio); // should be the same as height as it should be a square

        this.frog = Bitmap.createScaledBitmap(frog, width, height, false);

        this.posx = 3 * width;
        this.posy = (int) (GameView.screenHeight * 0.05 + GameView.screenHeight * screenHeightRatio * 12 - height);
    }

    public Bitmap getFrog() {
        return frog;
    }

}