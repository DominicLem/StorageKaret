package com.backend.karet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.karet.entity.PurchaseDetailEntity;
import com.backend.karet.entity.PurchaseEntity;
import com.backend.karet.exception.PurchaseTransactionException;
import com.backend.karet.repository.PurchaseDetailRepository;
import com.backend.karet.repository.PurchaseRepository;

@Service
public class PurchaseService {

    private final PurchaseRepository purchaseTransactionRepository;
    private final PurchaseDetailRepository purchaseDetailRepository;
    private final SupplierService supplierService;

    public PurchaseService(PurchaseRepository purchaseTransactionRepository,
                            PurchaseDetailRepository purchaseDetailRepository,
                            SupplierService supplierService) {
        this.purchaseTransactionRepository = purchaseTransactionRepository;
        this.purchaseDetailRepository = purchaseDetailRepository;
        this.supplierService = supplierService;
    }

    // public PurchaseEntity createTransaction(PurchaseEntity transaction, List<PurchaseDetailEntity> details) {
    //     try {
    //         transaction.setTotalTransaction(calculateTotalTransaction(details));
    //         transaction = purchaseTransactionRepository.save(transaction);
    //         details.forEach(detail -> {
    //             detail.setPurchaseTransaction(transaction);
    //             purchaseDetailRepository.save(detail);
    //             addSupplierPoints(detail);
    //         });
    //         return transaction;
    //     } catch (Exception e) {
    //         throw new PurchaseTransactionException("Failed to create transaction", e);
    //     }
    // }
    

    // Read, Update, Delete (similar to previous code)

    // Helper methods
    private Double calculateTotalTransaction(List<PurchaseDetailEntity> purchaseDetails) {
        return purchaseDetails.stream().mapToDouble(PurchaseDetailEntity::getTotalPrice).sum();
    }

    private void addSupplierPoints(PurchaseDetailEntity detail) {
        int points = 0;
        switch (detail.getGrade()) {
            case 'A':
                points = 10;
                break;
            case 'B':
                points = 8;
                break;
            case 'C':
                points = 5;
                break;
        }
        supplierService.updateSupplierPoints(detail.getPurchaseTransaction().getSupplier().getId(),
                                              detail.getWeight() * points);
    }
}

