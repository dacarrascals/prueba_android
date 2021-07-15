package com.example.prueba_android.Interfaces;

import com.example.prueba_android.Modelo.PeliculasResults;

import java.util.ArrayList;

public interface PresenterThemovieDBView {
    void consumo();
    void mensajeerror();
    void procesoexitoso(ArrayList<PeliculasResults> Peliculas);
}
