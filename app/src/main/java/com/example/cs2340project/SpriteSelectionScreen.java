package com.example.cs2340project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class SpriteSelectionScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spirte_selection_screen);

        ImageButton greenFrogBtn = (ImageButton) findViewById(R.id.green_frog);
        ImageButton blueFrogBtn = (ImageButton) findViewById(R.id.blue_frog);
        ImageButton redFrogBtn = (ImageButton) findViewById(R.id.red_frog);

        greenFrogBtn.setOnClickListener(view -> onBtnClick());
        blueFrogBtn.setOnClickListener(view -> onBtnClick());
        redFrogBtn.setOnClickListener(view -> onBtnClick());
    }


    public void onBtnClick()   {
        Intent intent = new Intent(SpriteSelectionScreen.this, GameScreen.class);
        startActivity(intent);
    }

}
