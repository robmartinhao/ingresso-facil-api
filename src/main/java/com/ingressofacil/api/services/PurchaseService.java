package com.ingressofacil.api.services;

import com.ingressofacil.api.dto.PurchaseDTO;
import com.ingressofacil.api.entities.Movie;
import com.ingressofacil.api.entities.Purchase;
import com.ingressofacil.api.repositories.MovieRepository;
import com.ingressofacil.api.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PurchaseService {

    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public void savePurchase(PurchaseDTO dto) {

        Movie movie = movieRepository.findById(dto.getMovieId()).get();

        var purchase = new Purchase();
        purchase.setMovie(movie);
        purchase.setEmail(dto.getEmail());
        purchase.setData(dto.getDataHora());
        purchase.setCpf(dto.getCpf());
        purchase.setCartaoCredito(dto.getCartaoCredito());
        purchase.setCodigoDeSeguranca(dto.getCodigoDeSeguranca());
        purchase.setValidade(dto.getValidade());
        purchase.setNome(dto.getNome());
        purchaseRepository.save(purchase);
    }
}
