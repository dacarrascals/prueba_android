package com.example.prueba_android.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.prueba_android.Modelo.PeliculasResults;
import com.example.prueba_android.R;
import com.example.prueba_android.Vista.DescripcionPeliculas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdaptadorMainActivity extends RecyclerView.Adapter<AdaptadorMainActivity.ViewHolderMP> {

    private ArrayList<PeliculasResults> results;
    private ArrayList<PeliculasResults> originalresults;

    private Context context;

    public AdaptadorMainActivity(ArrayList<PeliculasResults> results, Context context) {
        this.results = results;
        this.context = context;
        this.originalresults= new ArrayList<>();
        originalresults.addAll(results);
    }

    @NonNull
    @Override
    public ViewHolderMP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerpeliculas,null,false);
        return new ViewHolderMP(view);
    }






    @Override
    public void onBindViewHolder(@NonNull ViewHolderMP holder, int position) {


        holder.url="https://image.tmdb.org/t/p/w500/"+results.get(position).getPoster_path();
        Glide.with(context).load(holder.url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imagen);






        holder.itemView.setOnClickListener(view -> {
            holder.urldescripcion="https://image.tmdb.org/t/p/w500/"+results.get(position).getBackdrop_path();
            Intent intent= new Intent(context, DescripcionPeliculas.class);
            intent.putExtra("imagen",holder.urldescripcion);
            intent.putExtra("titulo",results.get(position).getTitle());
            intent.putExtra("lenguaje",results.get(position).getOriginal_language());
            intent.putExtra("fechalanza",results.get(position).getRelease_date());
            intent.putExtra("descripcion",results.get(position).getOverview());
            context.startActivity(intent);

        });

    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void filter(String strSearch){
        if(strSearch.length()==0){
            results.clear();
            results.addAll(originalresults);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
              List<PeliculasResults> pelis= results.stream().filter(i -> i.getTitle().toLowerCase().contains(strSearch)).collect(Collectors.toList());
                results.clear();
                results.addAll(pelis);
            }else{
                results.clear();
                for (PeliculasResults i: originalresults){
                    if(i.getTitle().toLowerCase().contains(strSearch)){
                        results.add(i);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public class ViewHolderMP extends RecyclerView.ViewHolder {

        private ImageView imagen,imagen2;
        private TextView titulo;
        private  String url;
        private String urldescripcion;


        public ViewHolderMP(@NonNull View itemView) {
            super(itemView);

            imagen=itemView.findViewById(R.id.poster);
            titulo= itemView.findViewById(R.id.title);

        }
    }
}
