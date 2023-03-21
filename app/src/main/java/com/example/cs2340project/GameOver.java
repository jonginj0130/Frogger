package com.example.cs2340project;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {
    TextView tvPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over_screen);
        int points = GameState.getPoints();
        tvPoints = findViewById(R.id.tvPoints);
        tvPoints.setText(points);
    }
}
