package com.example.testretrofit.json_mapper;

import java.util.List;

public class MovieResponse {

    // URL DEL ENDPOINT AL QUE ESTOY ATENDIENDO
    // https://api.themoviedb.org/3/movie/popular?api_key=c91d7d39465e28526be82a2d0af7b991

    // ATRIBUTOS
    private List<Movie> results;


    // GETTERS & SETTERS
    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
