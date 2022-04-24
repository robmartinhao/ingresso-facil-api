package com.ingressofacil.api.controllers;

import com.ingressofacil.api.dto.MovieDTO;
import com.ingressofacil.api.dto.ScoreDTO;
import com.ingressofacil.api.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping
    public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
        return scoreService.saveScore(dto);
    }
}
