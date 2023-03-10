package com.example.cs2340project;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class GameView extends View implements Runnable {
    private Context context; // context required to access resources
    private Bitmap lifeImage;
    private Bitmap riverTile;
    private Bitmap goalTile;
    private Bitmap roadTile;
    private Bitmap safeTile;
    // riverTile, goalTile, roadTile, and safeTile to be added.
    private Handler handler; // Utilized to _____
    private long updateMillis = 30; // Time Frame to update the view
    static int screenWidth;
    static int screenHeight;
    static double screenWidthRatio = 0.143;
    static double screenHeightRatio = 0.0714;
    private int life;
    private Score score;
    private int points = 0;
    private Paint scorePaint = new Paint();
    private boolean paused = false;

    private Vehicle vehicles;

    private Random random;

    private Frog frog;
    public GameView(Context context, Bundle bundle) {
        super(context);
        this.context = context;
        // Used to access the display size of the device
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point(); // stores the x (width) and y (height) coordinates of the display of the device
        display.getSize(size); // size now contains the x and y of the display of the device

        scorePaint.setTextSize(100);
        scorePaint.setTypeface(Typeface.MONOSPACE);

        this.score = new Score();

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

        this.vehicles = new Vehicle(context, screenWidthRatio, screenHeightRatio, lifeImage.getHeight());

        // sets # of lives
        String diff = bundle.getString("diff");
        this.life = 3;
        if (diff.equals("Easy")) {
            this.life = 5;
        } else if (diff.equals("Medium")) {
            this.life = 4;
        }
        handler = new Handler();
    }
    @Override
    public void run() {
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawBackground(canvas);
        drawFrogAtStart(canvas);
        updateScore(canvas);
        drawVehicleAtStart(canvas);

        if (!paused) {
            handler.postDelayed(this, updateMillis);

            vehicles.posx1 += vehicles.speed;
            vehicles.posx2 -= vehicles.speed;
            vehicles.posx3 += vehicles.speed;
            vehicles.posx4 -= vehicles.speed;

            if (vehicles.posx1 + vehicles.width > screenWidth) {
                vehicles.speed = -(vehicles.speed);
            } else if (vehicles.posx1 < 0) {
                vehicles.speed = -(vehicles.speed);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (event.getY() < screenHeight * 0.333) {
                //move up
                frog.posy -= screenHeight * screenHeightRatio;
                if (frog.posy < screenHeight * 0.05) {
                    frog.posy = (int) (GameView.screenHeight * 0.05);
                }
                score.increaseTilePassed();
                if (score.getTilesPassed() > 10) {
                    score = new Score();
                    points = 200;
                } else {
                    points = Math.max(points, score.getScore());
                }
            } else if (event.getY() > screenHeight * 0.666) {
                //move down
                frog.posy += screenHeight * screenHeightRatio;
                if (frog.posy > (GameView.screenHeight * 0.05 + GameView.screenHeight
                        * screenHeightRatio * 12 - frog.height)) {
                    frog.posy = (int) (GameView.screenHeight * 0.05 + GameView.screenHeight
                            * screenHeightRatio * 12 - frog.height);
                } else {
                    score.decreaseTilePassed();
                }
            } else {
                if (event.getX() < screenWidth / 2) {
                    //move left
                    frog.posx -= frog.width;
                    if (frog.posx < 0) {
                        frog.posx = 0;
                    }
                } else {
                    //move right
                    frog.posx += frog.width;
                    if (frog.posx > screenWidth - frog.width) {
                        frog.posx = screenWidth - frog.width;
                    }
                }
            }
        }
        return true;
    }

    // function that updates score on screen
    private void updateScore(Canvas canvas) {
        canvas.drawText("Score:" + points, 2, 90, scorePaint);
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

    private void drawVehicleAtStart(Canvas canvas) {
        canvas.drawBitmap(vehicles.getVehicle1(), vehicles.posx1, vehicles.posy1, null);
        canvas.drawBitmap(vehicles.getVehicle2(), vehicles.posx2, vehicles.posy2, null);
        canvas.drawBitmap(vehicles.getVehicle3(), vehicles.posx3, vehicles.posy3, null);
        canvas.drawBitmap(vehicles.getVehicle4(), vehicles.posx4, vehicles.posy4, null);
    }

}
