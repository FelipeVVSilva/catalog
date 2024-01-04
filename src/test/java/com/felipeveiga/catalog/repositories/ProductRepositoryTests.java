package com.felipeveiga.catalog.repositories;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.felipeveiga.catalog.entities.Product;

@DataJpaTest
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository repo;
	
	@Test
	public void deleteShouldDeleteProductWhenIdExists() {
		
		Long existingId = 1L;
		repo.deleteById(existingId);
		
		Optional<Product> result = repo.findById(existingId);
		
		Assertions.assertFalse(result.isPresent());
		
		
	}
	
	
}
