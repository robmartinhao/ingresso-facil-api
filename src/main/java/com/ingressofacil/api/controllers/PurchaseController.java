package com.ingressofacil.api.controllers;

import com.ingressofacil.api.dto.PurchaseDTO;
import com.ingressofacil.api.processing.Task;
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

    @PutMapping
    public void savePurchase(@RequestBody PurchaseDTO dto) {
        processing();
        purchaseService.savePurchase(dto);
    }

    private void processing() {
        Task t1 = new Task(0, 100000);
        t1.setName("Task1");
        Task t2 = new Task(100001, 200000);
        t2.setName("Task2");
        Task t3 = new Task(200002, 300000);
        t3.setName("Task3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("Total: " + (t1.getTotal() + t2.getTotal() + t3.getTotal()));
    }
}
