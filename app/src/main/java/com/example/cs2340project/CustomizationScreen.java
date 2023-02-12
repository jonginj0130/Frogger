package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
            Intent intent = new Intent(CustomizationScreen.this, SpriteSelectionScreen.class);
            startActivity(intent);
        }
    }

    public void onRadioButtonClicked(View view) {
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        int count = radioGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View button = radioGroup.getChildAt(i);
            if (((RadioButton) button).isChecked()) {
                button.setBackgroundResource(R.drawable.difficulty_checked);
                ((Button) button).setTextColor(getColor(R.color.checked));
            } else {
                button.setBackgroundResource(R.drawable.difficulty_unchecked);
                ((Button) button).setTextColor(getColor(R.color.unchecked));
            }
        }
    }
}