package com.ingressofacil.api.services;

import com.ingressofacil.api.repositories.MovieRepository;
import com.ingressofacil.api.repositories.UserRepository;
import com.ingressofacil.api.dto.MovieDTO;
import com.ingressofacil.api.dto.ScoreDTO;
import com.ingressofacil.api.entities.Score;
import com.ingressofacil.api.entities.User;
import com.ingressofacil.api.repositories.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDTO saveScore(ScoreDTO dto) {
        var user = userRepository.findByEmail(dto.getEmail());
        if (user == null) {
            user = new User();
            user.setEmail(dto.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        var movie = movieRepository.findById(dto.getMovieId()).get();
        var score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(dto.getScore());
        score =  scoreRepository.saveAndFlush(score);

        double avg = movie.getScores().stream().mapToDouble(Score::getValue).average().getAsDouble();
        movie.setScore(avg);
        movie.setCount(movie.getScores().size());

        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
