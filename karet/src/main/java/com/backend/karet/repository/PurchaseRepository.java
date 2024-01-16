package com.backend.karet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.karet.entity.PurchaseEntity;

public interface PurchaseRepository extends JpaRepository<PurchaseEntity, Long> {
}
