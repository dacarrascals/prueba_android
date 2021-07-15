package com.example.prueba_android.Interfaces;

import com.example.prueba_android.Modelo.PeliculasResults;

import java.util.ArrayList;

public interface InteractorThemovieDBView {

    void consumo();
    void procesoexitoso(ArrayList<PeliculasResults> Peliculas);
    void mensajeerror();

}
