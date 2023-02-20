package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle bundle = getIntent().getExtras();
        String diff = bundle.getString("diff");
        int numLives = 3;
        if (diff.equals("Easy")) {
            numLives = 5;
        } else if (diff.equals("Medium")) {
            numLives = 4;
        }

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // draw river tiles onto screen
        int resID;
        TileRow tileRow;
        int tileSize = (int) Math.round((0.30 * screenHeight)/4);
        for (int i = 1; i < 5; i++) {
            resID = getResources().getIdentifier("river" + i, "id", getPackageName());
            ImageView riverArea = findViewById(resID);
            tileRow = new TileRow(this, tileSize, R.drawable.river, screenWidth, false);
            riverArea.setImageBitmap(tileRow.tileRow);
        }
        // draw road tiles onto screen
        tileSize = (int) Math.round((0.35 * screenHeight)/5);
        for (int i = 1; i < 6; i++) {
            resID = getResources().getIdentifier("road" + i, "id", getPackageName());
            ImageView roadArea = findViewById(resID);
            tileRow = new TileRow(this, tileSize, R.drawable.road, screenWidth, true);
            roadArea.setImageBitmap(tileRow.tileRow);
        }
        // draw start tile onto screen
        tileSize = (int) Math.round((0.0833 * screenHeight));
        ImageView safeArea = findViewById(R.id.start);
        tileRow = new TileRow(this, tileSize, R.drawable.grass, screenWidth, true);
        safeArea.setImageBitmap(tileRow.tileRow);

        //draw rest tile onto screen
        safeArea = findViewById(R.id.rest);
        safeArea.setImageBitmap(tileRow.tileRow);

        //draw goal tile onto screen
        safeArea = findViewById(R.id.goal);
        tileRow = new TileRow(this, tileSize, R.drawable.gold, screenWidth, true);
        safeArea.setImageBitmap(tileRow.tileRow);
    }
}