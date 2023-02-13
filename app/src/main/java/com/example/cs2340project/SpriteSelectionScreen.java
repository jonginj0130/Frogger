package com.example.cs2340project;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class SpriteSelectionScreen extends AppCompatActivity {
    private ImageButton spriteSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spirte_selection_screen);

        ImageButton greenFrogBtn = (ImageButton) findViewById(R.id.green_frog);
        ImageButton blueFrogBtn = (ImageButton) findViewById(R.id.blue_frog);
        ImageButton redFrogBtn = (ImageButton) findViewById(R.id.red_frog);

        greenFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.green_frog, greenFrogBtn));
        blueFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.blue_frog, blueFrogBtn));
        redFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.red_frog, redFrogBtn));
    }


    public void onBtnClick(int color, ImageButton frogClicked) {
        if (frogClicked.equals(spriteSelected)) {
            Intent intent = new Intent(SpriteSelectionScreen.this, GameScreen.class);
            Bundle bundle = getIntent().getExtras();

            //specific sprite is an int because R.drawable.x is an id
            bundle.putInt("spriteColor", color);
            System.out.println(color);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            spriteSelected = frogClicked;

            //i tried pulling this out to class scope but it caused errors
            ImageButton greenFrogBtn = (ImageButton) findViewById(R.id.green_frog);
            ImageButton blueFrogBtn = (ImageButton) findViewById(R.id.blue_frog);
            ImageButton redFrogBtn = (ImageButton) findViewById(R.id.red_frog);

            //set all frog backgrounds back to blue
            greenFrogBtn.setBackgroundColor(Color.parseColor("#52b9ff"));
            blueFrogBtn.setBackgroundColor(Color.parseColor("#52b9ff"));
            redFrogBtn.setBackgroundColor(Color.parseColor("#52b9ff"));

            //set the clicked one to yellow
            frogClicked.setBackgroundColor(Color.parseColor("#ebd160"));
        }
    }

}
