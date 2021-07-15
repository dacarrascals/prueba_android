package com.example.prueba_android.Vista;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.prueba_android.Adaptadores.AdaptadorMainActivity;
import com.example.prueba_android.Interfaces.MainActivityView;
import com.example.prueba_android.Modelo.Peliculas;
import com.example.prueba_android.Modelo.PeliculasResults;
import com.example.prueba_android.Presentador.PresenterThemovieDB;
import com.example.prueba_android.R;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity implements  MainActivityView, SearchView.OnQueryTextListener {

    private PresenterThemovieDB presenterThemovieDB;
    private TextView msgerror;
    androidx.appcompat.widget.SearchView search;
    private RecyclerView recyclermainactivity;
    private AdaptadorMainActivity adaptadorMainActivity;
    /*private SearchView searchView;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msgerror= findViewById(R.id.msgerror);
        search=findViewById(R.id.buscador);
        recyclermainactivity= findViewById(R.id.recyclermainactivity);
        presenterThemovieDB= new PresenterThemovieDB(this);
        consumo();
        initListener();

    }


    @Override
    public void consumo() {
        presenterThemovieDB.consumo();

    }


     @Override
     public void procesoexitoso(ArrayList<PeliculasResults> Peliculas) {
        adaptadorMainActivity= new AdaptadorMainActivity(Peliculas,this);
        recyclermainactivity.setLayoutManager(new GridLayoutManager(this,2));
        recyclermainactivity.setAdapter(adaptadorMainActivity);
        recyclermainactivity.setVisibility(View.VISIBLE);
        msgerror.setVisibility(View.GONE);
     }

     @Override
    public void mensajeerror() {
        recyclermainactivity.setVisibility(View.GONE);
        msgerror.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

     @Override
     public boolean onQueryTextSubmit(String query) {
         return false;
     }

     @Override
     public boolean onQueryTextChange(String newText) {
        adaptadorMainActivity.filter(newText);
         return false;
     }

     private void initListener(){
        search.setOnQueryTextListener(this);
     }


 }