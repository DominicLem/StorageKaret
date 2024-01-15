package com.backend.karet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.karet.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
}