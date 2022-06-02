package com.ingressofacil.api.controllers;

import com.ingressofacil.api.dto.PurchaseDTO;
import com.ingressofacil.api.repositories.MovieRepository;
import com.ingressofacil.api.services.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    private MovieRepository movieRepository;

    @PutMapping
    public void savePurchase(@RequestBody PurchaseDTO dto) {

        purchaseService.savePurchase(dto);
    }
}
