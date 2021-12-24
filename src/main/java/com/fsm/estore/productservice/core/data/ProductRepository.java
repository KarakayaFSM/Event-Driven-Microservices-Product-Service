package com.fsm.estore.productservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductId(String id);

    Optional<Product> findByProductIdOrTitle(String productId, String title);
}
