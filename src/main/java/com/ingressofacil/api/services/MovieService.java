package com.ingressofacil.api.services;

import com.ingressofacil.api.repositories.MovieRepository;
import com.ingressofacil.api.dto.MovieDTO;
import com.ingressofacil.api.entities.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(MovieDTO::new);
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(MovieDTO::new).orElse(null);
    }
}
