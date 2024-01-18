package com.backend.karet.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.backend.karet.entity.PurchaseEntity;
import com.backend.karet.exception.PurchaseTransactionException;
import com.backend.karet.request.PurchaseTransactionRequest;
import com.backend.karet.service.PurchaseService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("api/transaction")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService){
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public PurchaseEntity createTransaction(@RequestBody PurchaseTransactionRequest request) {
        try {
            PurchaseEntity transaction = createTransactionFromRequest(request);
            return purchaseService.createTransaction(transaction, request.getDetails());
        } catch (PurchaseTransactionException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
        }
    }

    // Helper method to create a PurchaseEntity from the request
    private PurchaseEntity createTransactionFromRequest(PurchaseTransactionRequest request) {
        // Map request fields to PurchaseEntity properties
        PurchaseEntity transaction = new PurchaseEntity();
        // ... (set transaction properties)
        return transaction;
    }
    // Retrieve a specific purchase transaction by ID
    @GetMapping("/{id}")
    public PurchaseEntity getTransactionById(@PathVariable Long id) {
        return purchaseService.getPurchaseById(id);
    }

    // Retrieve all purchase transactions
    @GetMapping
    public List<PurchaseEntity> getAllTransactions() {
        return purchaseService.getAllPurchase();
    }

    // Update an existing purchase transaction
    @PutMapping("/{id}")
    public PurchaseEntity updateTransaction(@PathVariable Long id, @RequestBody PurchaseEntity transaction) {
        return purchaseService.updatePurchase(id, transaction);
    }

    // Delete a purchase transaction by ID
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        purchaseService.deletePurchase(id);
    }
}
