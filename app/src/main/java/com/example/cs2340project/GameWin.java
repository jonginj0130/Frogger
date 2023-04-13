package com.example.cs2340project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameWin extends AppCompatActivity {
    protected TextView tvPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_win_screen);
        int points = GameState.getPoints();
        tvPoints = findViewById(R.id.tvPoints);
        tvPoints.setText("" + points);
    }
    /**
     * Restarts the game and resets GameState
     * @param view ImageButton with restart icon
     */
    public void restart(View view) {
        Intent intent = new Intent(GameWin.this, CustomizationScreen.class);
        GameState.restart();
        startActivity(intent);
    }

    /**
     * Closes the app
     * @param view ImageButton with exit icon
     */
    public void exit(View view) {
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
