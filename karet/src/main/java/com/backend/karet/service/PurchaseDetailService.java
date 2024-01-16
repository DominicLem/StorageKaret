package com.backend.karet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.karet.entity.PurchaseDetailEntity;
import com.backend.karet.exception.PurchaseDetailNotFoundException;
import com.backend.karet.repository.PurchaseDetailRepository;

@Service
public class PurchaseDetailService {

    private final PurchaseDetailRepository purchaseDetailRepository;

    public PurchaseDetailService(PurchaseDetailRepository purchaseDetailRepository) {
        this.purchaseDetailRepository = purchaseDetailRepository;
    }

    // Create
    public PurchaseDetailEntity createPurchaseDetail(PurchaseDetailEntity purchaseDetail) {
        purchaseDetail.setTotalPrice(purchaseDetail.getWeight() * purchaseDetail.getPricePerKilogram());
        return purchaseDetailRepository.save(purchaseDetail);
    }

    // Read
    public List<PurchaseDetailEntity> getAllPurchaseDetails() {
        return purchaseDetailRepository.findAll();
    }

    public PurchaseDetailEntity getPurchaseDetailById(Long id) {
        // return purchaseDetailRepository.findById(id).orElseThrow(() -> new PurchaseDetailNotFoundException(id));
        return purchaseDetailRepository.findById(id).orElseThrow(() -> new PurchaseDetailNotFoundException(id));
    }

    // Update
    public PurchaseDetailEntity updatePurchaseDetail(Long id, PurchaseDetailEntity purchaseDetailDetails) {
        PurchaseDetailEntity purchaseDetail = getPurchaseDetailById(id);
        purchaseDetail.setTransactionDate(purchaseDetailDetails.getTransactionDate());
        purchaseDetail.setWeight(purchaseDetailDetails.getWeight());
        purchaseDetail.setPiece(purchaseDetailDetails.getPiece());
        purchaseDetail.setGrade(purchaseDetailDetails.getGrade());
        purchaseDetail.setPricePerKilogram(purchaseDetailDetails.getPricePerKilogram());
        purchaseDetail.setTotalPrice(purchaseDetail.getWeight() * purchaseDetail.getPricePerKilogram());
        return purchaseDetailRepository.save(purchaseDetail);
    }

    // Delete
    public void deletePurchaseDetail(Long id) {
        purchaseDetailRepository.deleteById(id);
    }
}
