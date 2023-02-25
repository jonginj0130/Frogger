package com.example.cs2340project;

import android.app.Activity;
import android.content.Context;
import android.gesture.Gesture;
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
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
    double screenWidthRatio = 0.143;
    double screenHeightRatio = 0.0714;
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
        this.frog = new Frog(spriteColor, context, screenWidthRatio, screenHeightRatio);


        lifeImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart); // Creates Bitmap
        lifeImage = Bitmap.createScaledBitmap(lifeImage, (int) (screenHeight * 0.05), (int) (screenHeight * 0.05), false); // Scales Bitmap
        riverTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.river, false).getTile();
        goalTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.gold, false).getTile();
        roadTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.road, false).getTile();
        safeTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.grass, false).getTile();

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
        drawFrogAtStart(canvas);

        if (!paused) {
            handler.postDelayed(this, UPDATE_MILLIS);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            float x1 = event.getX();
            float y1 = event.getY();
        }
        return true;
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

    private void drawFrogAtStart(Canvas canvas) {
        canvas.drawBitmap(frog.getFrog(), frog.posx, frog.posy, null);
    }

}
