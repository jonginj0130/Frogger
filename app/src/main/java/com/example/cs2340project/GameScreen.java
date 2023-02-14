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
        String diff = bundle.getString("diff");
        int numLives = 3;
        if (diff.equals("Easy")) {
            numLives = 5;
        } else if (diff.equals("Medium")) {
            numLives = 4;
        }

        TextView nameTextView = findViewById(R.id.nameText);
        nameTextView.setText("Name: " + bundle.getString("name"));

        TextView diffTextView = findViewById(R.id.diffText);
        diffTextView.setText("Difficulty: " + diff);

        TextView livesTextView = findViewById(R.id.livesText);
        livesTextView.setText("Lives: " + numLives);

        TextView pointsTextView = findViewById(R.id.pointsText);
        pointsTextView.setText("Points: 0");

        ImageView spriteImageView = findViewById(R.id.spriteImage);
        spriteImageView.setImageResource(bundle.getInt("spriteColor"));
    }


}