package com.backend.karet.exception;

public class PurchaseTransactionException extends RuntimeException {

    public PurchaseTransactionException(String message) {
        super(message);
    }

    public PurchaseTransactionException(String message, Throwable cause) {
        super(message, cause);
    }
    public PurchaseTransactionException(Long id) {
        super("Purchase not found with ID: " + id);
    }
}
