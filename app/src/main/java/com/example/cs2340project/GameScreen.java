package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class GameScreen extends AppCompatActivity {
    int numHearts = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle bundle = getIntent().getExtras();
        String diff = bundle.getString("diff");
        if (diff.equals("Easy")) {
            numHearts = 5;
        } else if (diff.equals("Medium")) {
            numHearts = 4;
        }
        drawLives(numHearts);

        ProgressBar pb = findViewById(R.id.timeBar);
        CountDownTimer timer = new CountDownTimer(5000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                pb.setProgress(Math.round(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                numHearts--;
                drawLives(numHearts);
                pb.setProgress(0);
                Toast.makeText(GameScreen.this, "Time Over!", Toast.LENGTH_SHORT).show();
            }
        }.start();

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        // draw river tiles onto screen
        int resID;
        TileRow tileRow;
        for (int i = 1; i < 5; i++) {
            resID = getResources().getIdentifier("river" + i, "id", getPackageName());
            ImageView riverArea = findViewById(resID);
            tileRow = new TileRow(this, R.drawable.river,screenHeight, screenWidth, false);
            riverArea.setImageBitmap(tileRow.getTileRow());
        }
        // draw road tiles onto screen
//        tileSize = (int) Math.round((0.35 * screenHeight) / 5);
        for (int i = 1; i < 6; i++) {
            resID = getResources().getIdentifier("road" + i, "id", getPackageName());
            ImageView roadArea = findViewById(resID);
            tileRow = new TileRow(this, R.drawable.road, screenHeight, screenWidth, true);
            roadArea.setImageBitmap(tileRow.getTileRow());
        }
        // draw start tile onto screen
//        tileSize = (int) Math.round((0.0833 * screenHeight));
        ImageView safeArea = findViewById(R.id.start);
        tileRow = new TileRow(this, R.drawable.grass, screenHeight, screenWidth, true);
        safeArea.setImageBitmap(tileRow.getTileRow());

        //draw rest tile onto screen
        safeArea = findViewById(R.id.rest);
        safeArea.setImageBitmap(tileRow.getTileRow());

        //draw goal tile onto screen
        ImageView goalArea = findViewById(R.id.goal);
        tileRow = new TileRow(this, R.drawable.gold, screenHeight, screenWidth, true);
        goalArea.setImageBitmap(tileRow.getTileRow());
    }

    // method to draw the hearts at the top left of the screen
    public void drawLives(int lives) {
        ImageView img;
        int resID;
        for (int i = 1; i <= 5; i++) {
            resID = getResources().getIdentifier("heart" + i, "id", getPackageName());
            img = findViewById(resID);
            img.setImageResource(0);
        }
        for (int i = 1; i <= lives; i++) {
            resID = getResources().getIdentifier("heart" + i, "id", getPackageName());
            img = findViewById(resID);
            img.setImageResource(R.drawable.heart);
        }
    }
}