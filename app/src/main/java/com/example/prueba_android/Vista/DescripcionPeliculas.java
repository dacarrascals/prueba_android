package com.example.prueba_android.Vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.prueba_android.Modelo.PeliculasResults;
import com.example.prueba_android.R;

import java.util.ArrayList;

public class DescripcionPeliculas extends AppCompatActivity {

    TextView titulo, lenguaje, descripcion, fechalanza;
    private Bundle bundle;
    ImageView imagen, atras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_peliculas);
        titulo= findViewById(R.id.titulo);
        lenguaje= findViewById(R.id.lenguaje);
        descripcion= findViewById(R.id.descripcion);
        fechalanza= findViewById(R.id.fechalanza);
        imagen=findViewById(R.id.imagen);
        bundle= getIntent().getExtras();
        imagen.setImageResource(bundle.getInt("imagen"));
        String imagenObtenida=bundle.getString("imagen");
        Glide.with(this).load(imagenObtenida).into(imagen);
        titulo.setText(bundle.getString("titulo"));
        lenguaje.setText(bundle.getString("lenguaje"));
        fechalanza.setText(bundle.getString("fechalanza"));
        descripcion.setText(bundle.getString("descripcion"));
        System.out.println("HOLAA"+imagen);

    }
}