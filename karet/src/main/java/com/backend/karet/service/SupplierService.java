package com.backend.karet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.backend.karet.entity.SupplierEntity;
import com.backend.karet.exception.SupplierNotFoundException;
import com.backend.karet.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierEntity createSupplier(SupplierEntity supplier) {
        return supplierRepository.save(supplier);
    }

    public List<SupplierEntity> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public SupplierEntity getSupplierById(Long id) {
        // return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));
        return supplierRepository.findById(id).orElseThrow(() -> new SupplierNotFoundException(id));      
    }

    public SupplierEntity updateSupplier(Long id, SupplierEntity supplierDetails) {
        SupplierEntity supplier = getSupplierById(id);
        supplier.setName(supplierDetails.getName());
        supplier.setAddress(supplierDetails.getAddress());
        supplier.setPoints(supplierDetails.getPoints());
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
    
    public void updateSupplierPoints(Long supplierId, double pointsToAdd) {
        // Logic to update supplier points goes here
        // Retrieve the supplier entity
        SupplierEntity supplier = supplierRepository.findById(supplierId).orElseThrow(() -> new SupplierNotFoundException(supplierId));
    
        // Update the supplier's points
        double newPoints = supplier.getPoints() + pointsToAdd;
        supplier.setPoints(newPoints);
    
        // Save the updated supplier
        supplierRepository.save(supplier);
    }
}
    
