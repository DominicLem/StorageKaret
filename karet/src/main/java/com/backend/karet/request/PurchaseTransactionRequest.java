package com.backend.karet.request;

import java.sql.Date;
import java.util.List;

import com.backend.karet.entity.PurchaseDetailEntity;

public class PurchaseTransactionRequest {

    // Properties for transaction details
    // (Add the necessary properties based on your request structure)
    private Long supplierId; // Example property
    private Date purchaseDate; // Example property
    private Double totalTransaction;
    // ... other properties

    // List of purchase details (adjust based on nesting structure)
    private List<PurchaseDetailEntity> details;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Double getTotalTransaction() {
        return totalTransaction;
    }

    public void setTotalTransaction(Double totalTransaction) {
        this.totalTransaction = totalTransaction;
    }

    public List<PurchaseDetailEntity> getDetails() {
        return details;
    }

    public void setDetails(List<PurchaseDetailEntity> details) {
        this.details = details;
    }

    // Getters and setters for properties
    // ...
}

