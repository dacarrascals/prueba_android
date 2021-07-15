package com.example.prueba_android.Presentador;

import com.example.prueba_android.Interfaces.InteractorThemovieDBView;
import com.example.prueba_android.Interfaces.MainActivityView;
import com.example.prueba_android.Interfaces.PresenterThemovieDBView;
import com.example.prueba_android.Modelo.InteractorThemovieDB;
import com.example.prueba_android.Modelo.PeliculasResults;

import java.util.ArrayList;

public class PresenterThemovieDB implements PresenterThemovieDBView {

    private MainActivityView mainActivityView;
    private InteractorThemovieDBView interactorThemovieDBView;

    public PresenterThemovieDB(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        this.interactorThemovieDBView = new InteractorThemovieDB(this);
    }


    @Override
    public void consumo() {
        interactorThemovieDBView.consumo();
    }

    @Override
    public void mensajeerror() {
        mainActivityView.mensajeerror();
    }

    @Override
    public void procesoexitoso(ArrayList<PeliculasResults> Peliculas) {
        mainActivityView.procesoexitoso(Peliculas);
    }


}
