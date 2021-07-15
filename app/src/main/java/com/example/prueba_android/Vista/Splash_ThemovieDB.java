package com.example.prueba_android.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.prueba_android.R;

public class Splash_ThemovieDB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__themovie_d_b);

        new Handler().postDelayed(() -> {
            Intent intent= new Intent(Splash_ThemovieDB.this, MainActivity.class);
            startActivity(intent);
            finish();
        },3000);


    }
}