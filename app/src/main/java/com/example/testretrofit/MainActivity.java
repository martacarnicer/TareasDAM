package com.example.testretrofit;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testretrofit.json_mapper.Movie;
import com.example.testretrofit.json_mapper.MovieResponse;
import com.example.testretrofit.retrofit.RetrofitClient;
import com.example.testretrofit.services.MovieService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btn01;
    private Button btn02;
    private Button btn03;
    private MovieService movieService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);

        movieService = new MovieService();

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerPeliculasPopulares();
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarPeliculas("titanic"); // Puedes cambiar la consulta según necesites
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDetallesPelicula(550); // Cambia el ID según la película que quieras consultar
            }
        });
    }

    private void obtenerPeliculasPopulares() {
        movieService.obtenerPeliculasPopulares(new MovieService.MovieServiceCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                for (Movie myMovie : movies) {
                    Toast.makeText(MainActivity.this, "Popular Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void buscarPeliculas(String query) {
        movieService.buscarPeliculas(query, new MovieService.MovieServiceCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                for (Movie myMovie : movies) {
                    Toast.makeText(MainActivity.this, "Found Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void obtenerDetallesPelicula(int movieId) {
        movieService.obtenerDetallesDePelicula(movieId, new MovieService.MovieServiceCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                if (!movies.isEmpty()) {
                    Movie movie = movies.get(0);
                    Toast.makeText(MainActivity.this, "Detalles de: " + movie.getTitle(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(String message) {
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}