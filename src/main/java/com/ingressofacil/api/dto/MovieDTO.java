package com.ingressofacil.api.dto;

import com.ingressofacil.api.entities.Movie;

public class MovieDTO {

    private Long id;
    private String title;
    private String image;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, String image) {
        this.id = id;
        this.title = title;
        this.image = image;
    }

    public MovieDTO(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        image = movie.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
