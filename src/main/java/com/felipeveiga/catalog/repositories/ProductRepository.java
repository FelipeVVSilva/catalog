package com.felipeveiga.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipeveiga.catalog.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
