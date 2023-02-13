package com.example.cs2340project;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

        greenFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.green_frog));
        blueFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.blue_frog));
        redFrogBtn.setOnClickListener(view -> onBtnClick(R.drawable.red_frog));
    }


    public void onBtnClick(int color) {
        Intent intent = new Intent(SpriteSelectionScreen.this, GameScreen.class);

        Bundle bundle = getIntent().getExtras();

        //specific sprite is an int because R.drawable.x is an id
        bundle.putInt("spriteColor", color);
        System.out.println(color);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
