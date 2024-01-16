package com.backend.karet.exception;

public class PurchaseDetailNotFoundException extends RuntimeException{
    public PurchaseDetailNotFoundException(Long id) {
        super("Purchase Detail not found with ID: " + id);
    }
}

