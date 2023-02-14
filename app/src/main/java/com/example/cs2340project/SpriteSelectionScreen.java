package com.example.cs2340project;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class SpriteSelectionScreen extends AppCompatActivity {
    private ImageButton spriteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spirte_selection_screen);

        ImageButton greenFrogBtn = findViewById(R.id.green_frog);
        ImageButton blueFrogBtn = findViewById(R.id.blue_frog);
        ImageButton redFrogBtn = findViewById(R.id.red_frog);


        greenFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.green_frog, greenFrogBtn));
        blueFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.blue_frog, blueFrogBtn));
        redFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.red_frog, redFrogBtn));

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        TextView titleView = findViewById(R.id.selection_title);
        titleView.setText(name + ", choose your character");
    }

    public void onBtnClick(int color, ImageButton frogClicked) {
        if (frogClicked.equals(spriteSelected)) {
            Intent intent = new Intent(SpriteSelectionScreen.this, GameScreen.class);
            Bundle bundle = getIntent().getExtras();

            //specific sprite is an int because R.drawable.x is an id
            bundle.putInt("spriteColor", color);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            spriteSelected = frogClicked;

            //i tried pulling this out to class scope but it caused errors
            ImageButton greenFrogBtn = findViewById(R.id.green_frog);
            ImageButton blueFrogBtn = findViewById(R.id.blue_frog);
            ImageButton redFrogBtn = findViewById(R.id.red_frog);

            //set all frog backgrounds back to blue
            greenFrogBtn.setBackgroundResource(R.color.spriteBackground);
            blueFrogBtn.setBackgroundResource(R.color.spriteBackground);
            redFrogBtn.setBackgroundResource(R.color.spriteBackground);

            //set the clicked one to yellow
            frogClicked.setBackgroundResource(R.color.selectedSpriteBackground);
        }
    }

}
