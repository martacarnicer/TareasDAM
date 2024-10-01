package com.example.testretrofit.services;

import android.widget.Toast;

import com.example.testretrofit.MainActivity;
import com.example.testretrofit.json_mapper.Movie;
import com.example.testretrofit.json_mapper.MovieResponse;
import com.example.testretrofit.movies_api.MoviesAPI;
import com.example.testretrofit.retrofit.RetrofitClient;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieService {

    private MoviesAPI moviesAPI;

    public MovieService() {
        moviesAPI = RetrofitClient.getInstance();
    }

    // Método para obtener películas populares

    public void obtenerPeliculasPopulares(final MovieServiceCallback callback) {
        String apiKey = "c91d7d39465e28526be82a2d0af7b991"; // Tu API Key
        String language = "es-ES"; // Idioma
        Integer page = 1; // Número de página

        Call<MovieResponse> call = moviesAPI.getPopularMovies(apiKey, language, page);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getResults());
                } else {
                    callback.onError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onError("Fallo en la conexión: " + t.getMessage());
            }
        });
    }

    // Método para buscar películas
    public void buscarPeliculas(String query, final MovieServiceCallback callback) {
        Call<MovieResponse> call = moviesAPI.searchMovies("c91d7d39465e28526be82a2d0af7b991", "es-ES", query, 1);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body().getResults());
                } else {
                    callback.onError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                callback.onError("Fallo en la conexión: " + t.getMessage());
            }
        });
    }

    // Método para obtener detalles de una película
    public void obtenerDetallesDePelicula(int movieId, final MovieServiceCallback callback) {
        Call<Movie> call = moviesAPI.getMovieDetails(movieId, "c91d7d39465e28526be82a2d0af7b991", "es-ES");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(Collections.singletonList(response.body())); // Enviamos la película como una lista
                } else {
                    callback.onError("Error en la respuesta");
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                callback.onError("Fallo en la conexión: " + t.getMessage());
            }
        });
    }

    // Interfaz para manejar los resultados
    public interface MovieServiceCallback {
        void onSuccess(List<Movie> movies);
        void onError(String message);
    }
}
