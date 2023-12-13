package com.felipeveiga.catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.catalog.entities.Category;
import com.felipeveiga.catalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public List<Category> findAll(){
		List<Category> categories = repo.findAll();
		return categories;
	}
	
	
}
