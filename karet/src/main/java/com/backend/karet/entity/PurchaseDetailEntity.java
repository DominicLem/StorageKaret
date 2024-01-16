package com.backend.karet.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PurchaseDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchaseTransaction;

    @Column(name = "transaction_date")
    private Date transactionDate;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "piece")
    private Integer piece;

    @Column(name = "grade")
    private Character grade;

    @Column(name = "price_per_kilogram")
    private Double pricePerKilogram;

    @Column(name = "total_price")
    private Double totalPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getPiece() {
        return piece;
    }

    public void setPiece(Integer piece) {
        this.piece = piece;
    }

    public Character getGrade() {
        return grade;
    }

    public void setGrade(Character grade) {
        this.grade = grade;
    }

    public Double getPricePerKilogram() {
        return pricePerKilogram;
    }

    public void setPricePerKilogram(Double pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PurchaseEntity getPurchaseTransaction() {
        return purchaseTransaction;
    }

    public void setPurchaseTransaction(PurchaseEntity purchaseTransaction) {
        this.purchaseTransaction = purchaseTransaction;
    }
    

    
}
