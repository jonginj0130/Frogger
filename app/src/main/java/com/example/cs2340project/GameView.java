package com.example.cs2340project;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;
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
    protected static int screenWidth;
    protected static int screenHeight;
    protected static double screenWidthRatio = 0.143;
    protected static double screenHeightRatio = 0.0714;
    private int life;
    private Score score;
    private int points = 0;
    private Paint scorePaint = new Paint();
    private boolean paused = false;

    private Rect riverRect;

    /*
         [
    row0   [Vehicle, Vehicle]
    row1   [Vehicle, Vehicle]
    row2   [Vehicle, Vehicle]
    row3   [Vehicle, Vehicle]
    row4   [Vehicle, Vehicle]
         ]
     */
    private ArrayList<Vehicle>[] vehicles = new ArrayList[5];

    private Random random;
    private Frog frog;
    public GameView(Context context, Bundle bundle) {
        super(context);
        this.context = context;
        // Used to access the display size of the device
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        // stores the x (width) and y (height) coordinates of the display of the device

        display.getSize(size); // size now contains the x and y of the display of the device


        scorePaint.setTextSize(100);
        scorePaint.setTypeface(Typeface.MONOSPACE);

        this.score = new Score();

        this.screenWidth = size.x;
        this.screenHeight = size.y;
        int spriteColor = bundle.getInt("spriteColor"); // Accessing from bundle
        this.frog = new Frog(spriteColor, context, screenWidthRatio, screenHeightRatio);


        lifeImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.heart);
        // Creates Bitmap
        lifeImage = Bitmap.createScaledBitmap(lifeImage, (int) (screenHeight * 0.05),
                (int) (screenHeight * 0.05), false); // Scales Bitmap
        riverTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.river, false).getTile();
        goalTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.gold, false).getTile();
        roadTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.road, false).getTile();
        safeTile = new Tile(context, (int) (screenWidth * screenWidthRatio),
                (int) (screenHeight * screenHeightRatio), R.drawable.grass, false).getTile();

        // initializing vehicles. Refer to this function to modify vehicles.
        initializeVehicles();

        // sets # of lives
        String diff = GameState.getDifficulty();
        this.life = 3;
        if (diff.equals("Easy")) {
            this.life = 5;
        } else if (diff.equals("Medium")) {
            this.life = 4;
        }
        handler = new Handler();

        //Calculating for river collision
        riverRect = new Rect(0, lifeImage.getHeight(), screenWidth,
                riverTile.getWidth() * 5 + lifeImage.getHeight());
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
            boolean isRight = true;
            for (ArrayList<Vehicle> rowVehicles : vehicles) {
                for (Vehicle vehicle : rowVehicles) {
                    moveVehicle(vehicle, isRight);
                    if (Rect.intersects(vehicle.getRect(), frog.getRect())) {

                        GameState.setPoints(Math.max(points, GameState.getPoints()));
                        score.setScore(0);
                        score.setTilesPassed(0);

                        if (life == 1) {
                            paused = true;
                            handler = null;
                            Intent intent =  new Intent(context, GameOver.class);
                            context.startActivity(intent);
                            ((Activity) context).finish();
                        } else {
                            life -= 1;
                            points = 0;
                            for (int i = life; i > 0; i--) {
                                canvas.drawBitmap(lifeImage,
                                        this.screenWidth - lifeImage.getWidth() * i, 0, null);
                            }
                            moveFrogStart();
                        }

                    }
                    //collision with river
                    if (Rect.intersects(riverRect, frog.getRect())) {

                        GameState.setPoints(Math.max(points, GameState.getPoints()));
                        score.setScore(0);
                        score.setTilesPassed(0);

                        if (life == 1) {
                            paused = true;
                            handler = null;
                            Intent intent =  new Intent(context, GameOver.class);
                            context.startActivity(intent);
                            ((Activity) context).finish();
                        } else {
                            life -= 1;
                            points = 0;
                            for (int i = life; i > 0; i--) {
                                canvas.drawBitmap(lifeImage,
                                        this.screenWidth - lifeImage.getWidth() * i, 0, null);
                            }
                            moveFrogStart();
                        }
                    }
                }
                isRight = !isRight;
            }
        }
    }

    private void moveFrogStart() {
        frog.posx = 3 * frog.width;
        frog.posy = (int) (GameView.screenHeight * 0.05
                + GameView.screenHeight * screenHeightRatio * 12 - frog.height);
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
                    this.screenWidth - lifeImage.getWidth() * i, 0, null);
        }
        int numTiles = (int) Math.ceil((double) screenWidth / riverTile.getWidth()); // Should be 12
        int top = 0;
        top += (int) lifeImage.getHeight();
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(goalTile,
                    goalTile.getWidth() * i, top, null);
        }
        top += (int) Math.ceil(screenHeight * 0.0714);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < numTiles; j++) {
                canvas.drawBitmap(riverTile,
                        riverTile.getWidth() * j, top,  null);
            }
            top += (int) Math.ceil(screenHeight * 0.0714);
        }
        for (int i = 0; i < numTiles; i++) {
            canvas.drawBitmap(safeTile,
                    safeTile.getWidth() * i, top, null);
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
                    safeTile.getWidth() * i, top, null);
        }
        top += (int) Math.ceil(screenHeight * 0.0714);
    }

    // Private function used to set up vehicles
    private void initializeVehicles() {

        int tileWidth = (int) (screenWidth * screenWidthRatio);
        int tileHeight = (int) (screenHeight * screenHeightRatio);
        // Initializing ArrayList
        for (int i = 0; i < 5; i++) {
            vehicles[i] = new ArrayList<Vehicle>();
        }

        Vehicle vehicle0 = new Vehicle(context, R.drawable.police_car, tileWidth,
                (int) (tileHeight * 0.8), 0,
                (float) ((GameView.screenHeight * 0.0714 * 6) + lifeImage.getHeight()
                        + (tileHeight / 8)),
                20);
        Vehicle vehicle1 = new Vehicle(context, R.drawable.police_car, tileWidth,
                (int) (tileHeight * 0.8), 4 * tileWidth,
                (float) ((GameView.screenHeight * 0.0714 * 6) + lifeImage.getHeight()
                        + (tileHeight / 8)), 20);
        Vehicle vehicle2 = new Vehicle(context, R.drawable.red_car, tileWidth,
                (int) (tileHeight * 0.8), GameView.screenWidth,
                (float) ((GameView.screenHeight * 0.0714 * 7) + lifeImage.getHeight()
                        + (tileHeight / 8)),
                20);
        Vehicle vehicle3 = new Vehicle(context, R.drawable.big_truck, tileWidth * 2,
                (int) (tileHeight * 0.8), 0,
                (float) ((GameView.screenHeight * 0.0714 * 8) + lifeImage.getHeight()
                        + (tileHeight / 8)),
                15);
        Vehicle vehicle4 = new Vehicle(context, R.drawable.small_truck, (int) (tileWidth * 1.5),
                (int) (tileHeight * 0.8), GameView.screenWidth,
                (float) ((GameView.screenHeight * 0.0714 * 9) + lifeImage.getHeight())
                        + (tileHeight / 8),
                15);
        Vehicle vehicle5 = new Vehicle(context, R.drawable.police_car, tileWidth,
                (int) (tileHeight * 0.8), 2 * tileWidth,
                (float) ((GameView.screenHeight * 0.0714 * 10) + lifeImage.getHeight())
                        + (tileHeight / 8),
                8);
        // Adding each vehicle to the arraylist Vehicles
        vehicles[0].add(vehicle0);
        vehicles[0].add(vehicle1);
        vehicles[1].add(vehicle2);
        vehicles[2].add(vehicle3);
        vehicles[3].add(vehicle4);
        vehicles[4].add(vehicle5);
    }
    private void moveVehicle(Vehicle vehicle, Boolean isRight) {
        if (isRight) {
            vehicle.posx += vehicle.speed;
            if (vehicle.posx >= screenWidth) {
                vehicle.posx = -vehicle.width;
            }
        } else {
            vehicle.posx -= vehicle.speed;
            if (vehicle.posx <= -vehicle.width) {
                vehicle.posx = screenWidth;
            }
        }
    }

    private void drawFrogAtStart(Canvas canvas) {
        canvas.drawBitmap(frog.getFrog(), frog.posx, frog.posy, null);
    }

    private void drawVehicleAtStart(Canvas canvas) {
        for (ArrayList<Vehicle> rowVehicles : vehicles) {
            for (Vehicle vehicle : rowVehicles) {
                canvas.drawBitmap(vehicle.getVehicle(), vehicle.posx, vehicle.posy, null);
            }
        }
    }
}
