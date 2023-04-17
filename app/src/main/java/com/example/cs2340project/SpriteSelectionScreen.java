package com.example.cs2340project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class SpriteSelectionScreen extends AppCompatActivity {
    private ImageButton spriteSelected;
    private ImageButton greenFrogBtn;
    private ImageButton blueFrogBtn;
    private ImageButton redFrogBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spirte_selection_screen);

        greenFrogBtn = findViewById(R.id.green_frog);
        blueFrogBtn = findViewById(R.id.blue_frog);
        redFrogBtn = findViewById(R.id.red_frog);

        greenFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.green_frog, greenFrogBtn));
        blueFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.blue_frog, blueFrogBtn));
        redFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.red_frog, redFrogBtn));
    }

    public void onBtnClick(int color, ImageButton frogClicked) {
        if (frogClicked.equals(spriteSelected)) {
            Intent intent = new Intent(SpriteSelectionScreen.this, GameActivity.class);
            Bundle bundle = getIntent().getExtras();

            //specific sprite is an int because R.drawable.x is an id
            bundle.putInt("spriteColor", color);
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            spriteSelected = frogClicked;
            resetBackground();
            //set the clicked one to yellow
            frogClicked.setBackgroundResource(R.color.selectedSpriteBackground);
        }
    }

    private void resetBackground() {
        //set all frog backgrounds back to blue
        greenFrogBtn.setBackgroundResource(R.color.spriteBackground);
        blueFrogBtn.setBackgroundResource(R.color.spriteBackground);
        redFrogBtn.setBackgroundResource(R.color.spriteBackground);
    }
}
