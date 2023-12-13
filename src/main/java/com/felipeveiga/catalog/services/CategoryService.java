package com.felipeveiga.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipeveiga.catalog.entities.Category;
import com.felipeveiga.catalog.entities.dto.CategoryDTO;
import com.felipeveiga.catalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	public List<CategoryDTO> findAll(){
		List<Category> categories = repo.findAll();
		List<CategoryDTO> categoriesDTO = categories.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
		return categoriesDTO;
	}
	
	
}
