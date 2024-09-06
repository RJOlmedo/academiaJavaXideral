package com.example.jpacrudapi.repository;

import com.example.jpacrudapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
