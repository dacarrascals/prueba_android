package com.example.prueba_android.Interfaces;



import com.example.prueba_android.Modelo.Peliculas;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ServicioApi {

    @GET("https://api.themoviedb.org/3/movie/popular?api_key=2e2967a2ffb68e7db0da67c8928a91d1")
    Call <Peliculas> obtenerPeliculas();



}
