package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CustomizationScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customization_screen);
    }

    public void onPlayBtnClick(View view) {
        TextView playerName = findViewById(R.id.playerName);
        String name = playerName.getText().toString();
        if (name.equals("") || name.trim().isEmpty()) {
            playerName.setError("Please enter a name");
        } else {
            Intent intent = new Intent(CustomizationScreen.this, GameScreen.class);
            startActivity(intent);
        }
    }
}