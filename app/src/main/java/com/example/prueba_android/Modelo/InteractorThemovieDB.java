package com.example.prueba_android.Modelo;

import com.example.prueba_android.Interfaces.InteractorThemovieDBView;
import com.example.prueba_android.Interfaces.PresenterThemovieDBView;
import com.example.prueba_android.Interfaces.ServicioApi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorThemovieDB implements InteractorThemovieDBView {

    private PresenterThemovieDBView presenterThemovieDBView;

    public InteractorThemovieDB(PresenterThemovieDBView presenterThemovieDBView) {
        this.presenterThemovieDBView = presenterThemovieDBView;
    }




    @Override
    public void consumo() {

        //Se buscan los datos con retrofit

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ServicioApi service=retrofit.create(ServicioApi.class);
        Call call=service.obtenerPeliculas();

        call.enqueue(new Callback<Peliculas>() {
            @Override
            public void onResponse(retrofit2.Call<Peliculas> call, Response<Peliculas> response) {

                if(!response.isSuccessful()){
                    System.out.println("Proceso fallido!");
                    return;
                }

                Peliculas datosPeliculas= response.body();
                ArrayList<PeliculasResults> peliculas = datosPeliculas.getResults();

                if(datosPeliculas!=null){
                    procesoexitoso(peliculas);
                    System.out.println("Proceso exitoso!");

                }

            }

            @Override
            public void onFailure(retrofit2.Call<Peliculas> call, Throwable t) {
              /*  procesoFallido();*/
                mensajeerror();

            }
        });



    }

    @Override
    public void procesoexitoso(ArrayList<PeliculasResults> Peliculas) {
        presenterThemovieDBView.procesoexitoso(Peliculas);
    }

    @Override
    public void mensajeerror() {
        presenterThemovieDBView.mensajeerror();

    }
}
