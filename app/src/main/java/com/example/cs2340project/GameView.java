package com.example.cs2340project;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class GameView extends View implements Runnable {
    Context context; // context required to access resources
    Bitmap lifeImage, riverTile, goalTile, roadTile, safeTile; // riverTile, goalTile, roadTile, and safeTile to be added.
    Handler handler; // Utilized to _____
    long UPDATE_MILLIS = 30; // Time Frame to update the view
    static int screenWidth, screenHeight;
    int life;
    int points = 0;
    boolean paused = false;

    Frog frog;
    public GameView(Context context, Bundle bundle) {
        super(context);
        this.context = context;
        // Used to access the display size of the device
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();

        Point size = new Point(); // stores the x (width) and y (height) coordinates of the display of the device
        display.getSize(size); // size now contains the x and y of the display of the device
        this.screenWidth = size.x;
        this.screenHeight = size.y;

        int spriteColor = bundle.getInt("spriteColor"); // Accessing from bundle
        Frog frog = new Frog(spriteColor, context);

        lifeImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart); // Creates Bitmap
        lifeImage = Bitmap.createScaledBitmap(lifeImage, (int) (screenHeight * 0.05), (int) (screenHeight * 0.05), false); // Scales Bitmap
        riverTile = BitmapFactory.decodeResource(context.getResources(), R.drawable.river);
        riverTile = Bitmap.createScaledBitmap(riverTile, (int) (screenWidth * 0.0833), (int) (screenHeight * 0.0714), false);
        goalTile = BitmapFactory.decodeResource(context.getResources(), R.drawable.gold);
        goalTile = Bitmap.createScaledBitmap(goalTile, (int) (screenWidth * 0.0833), (int) (screenHeight * 0.0714), false);
        roadTile = BitmapFactory.decodeResource(context.getResources(), R.drawable.road);
        roadTile = Bitmap.createScaledBitmap(roadTile, (int) (screenWidth * 0.0833), (int) (screenHeight * 0.0714), false);
        safeTile = BitmapFactory.decodeResource(context.getResources(), R.drawable.grass);
        safeTile = Bitmap.createScaledBitmap(safeTile, (int) (screenWidth * 0.0833), (int) (screenHeight * 0.0714), false);
        // sets # of lives
        String diff = bundle.getString("diff");
        if (diff.equals("Easy")) {
            this.life = 5;
        } else if (diff.equals("Medium")) {
            this.life = 4;
        } else {
            this.life = 3;
        }
        handler = new Handler();
    }

    @Override
    public void run() {
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
/*        Paint scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize((float) ();
        scorePaint. setTextAlign(Paint.Align.LEFT);
        canvas.drawText("Lives: ", 0, (float) (screenHeight * 0.0714), scorePaint);*/
        drawBackground(canvas);
    }

    // Function that draws background with lives and tiles.
    private void drawBackground(Canvas canvas) {
        for (int i = life; i > 0; i--) {
            canvas.drawBitmap(lifeImage,
                    this.screenWidth - lifeImage.getWidth() * i, 0,null);
        }
        int numTiles = (int) Math.ceil((double) screenWidth / riverTile.getWidth()); // Should be 12
        int top = 0;
        top += (int) lifeImage.getHeight();
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(goalTile,
                    goalTile.getWidth() * i, top,null);
        }
        top += (int) Math.ceil(screenHeight * 0.0714);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < numTiles; j++) {
                canvas.drawBitmap(riverTile,
                        riverTile.getWidth() * j, top, null);
            }
            top += (int) Math.ceil(screenHeight * 0.0714);
        }
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(safeTile,
                    safeTile.getWidth() * i, top,null);
        }
        top += (int) Math.ceil(screenHeight * 0.0714);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < numTiles; j++) {
                canvas.drawBitmap(roadTile,
                        roadTile.getWidth() * j, top, null);
            }
            top += (int) Math.ceil(screenHeight * 0.0714);
        }
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(safeTile,
                    safeTile.getWidth() * i, top,null);
        }
        top += (int) Math.ceil(screenHeight * 0.0714);
    }

}
