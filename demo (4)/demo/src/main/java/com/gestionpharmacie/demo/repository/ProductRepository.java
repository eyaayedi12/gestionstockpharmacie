package com.gestionpharmacie.demo.repository;

import com.gestionpharmacie.demo.entity.Product;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    @Override
    Optional<Product> findById(Long aLong);
    boolean existsProductByName(String name);

    @Override
    void deleteById(Long aLong);
}
