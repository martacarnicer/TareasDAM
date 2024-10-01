package com.example.testretrofit.movies_api;

import com.example.testretrofit.json_mapper.Movie;
import com.example.testretrofit.json_mapper.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MoviesAPI {

        @GET("movie/popular")
        Call<MovieResponse> getPopularMovies(@Query("api_key") String apiKey,
                                             @Query("language") String language,
                                             @Query("page") Integer page);

        @GET("search/movie")
        Call<MovieResponse> searchMovies(@Query("api_key") String apiKey,
                                         @Query("language") String language,
                                         @Query("query") String query,
                                         @Query("page") Integer page);

        @GET("movie/{movie_id}")
        Call<Movie> getMovieDetails(@Path("movie_id") int movieId,
                                    @Query("api_key") String apiKey,
                                    @Query("language") String language);
    }


