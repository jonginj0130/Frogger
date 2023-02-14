package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        Bundle bundle = getIntent().getExtras();
        int numLives = 3;
        switch (bundle.getString("diff")) {
            case "Easy":
                numLives = 5;
                break;
            case "Medium":
                numLives = 4;
                break;
        }

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText("Name: " + bundle.getString("name"));

        TextView diffTextView = findViewById(R.id.diffText);
        diffTextView.setText("Difficulty: " + bundle.getString("diff"));

        TextView livesTextView = findViewById(R.id.livesText);
        livesTextView.setText("Lives: " + numLives);

        TextView pointsTextView = findViewById(R.id.pointsText);
        pointsTextView.setText("Points: 0");

        ImageView spriteImageView = findViewById(R.id.spriteImage);
        spriteImageView.setImageResource(bundle.getInt("spriteColor"));
    }


}