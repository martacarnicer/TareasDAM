package com.example.testretrofit.json_mapper;

public class Movie {

    // ATRIBUTOS. SON LOS QUE TAL CUAL ME VIENEN EN LA API. ¡¡ MISMO NOMBRE !!
    private int id;
    private String title;
    private String overview;
    private String poster_path;


    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


}
