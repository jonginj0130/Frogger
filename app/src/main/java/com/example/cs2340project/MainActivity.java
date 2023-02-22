package com.example.cs2340project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartBtnClick(View view) {
        Intent intent = new Intent(MainActivity.this, CustomizationScreen.class);
        startActivity(intent);
    }

    public void onExitBtnClick(View view) {
        finish();
        System.exit(0);
    }
}