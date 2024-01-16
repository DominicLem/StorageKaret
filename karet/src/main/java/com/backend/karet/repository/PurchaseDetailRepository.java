package com.backend.karet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.karet.entity.PurchaseDetailEntity;

public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetailEntity, Long> {
}
