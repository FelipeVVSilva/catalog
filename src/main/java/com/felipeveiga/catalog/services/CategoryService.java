package com.felipeveiga.catalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felipeveiga.catalog.entities.Category;
import com.felipeveiga.catalog.entities.dto.CategoryDTO;
import com.felipeveiga.catalog.repositories.CategoryRepository;
import com.felipeveiga.catalog.services.exceptions.ResourceNotFoundException;



@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repo;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> categories = repo.findAll();
		List<CategoryDTO> categoriesDTO = categories.stream().map(cat -> new CategoryDTO(cat)).collect(Collectors.toList());
		return categoriesDTO;
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Category entity = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id of category not found"));
		return new CategoryDTO(entity);
	}
	
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		dto.setId(null);
		Category entity = new Category(dto);
		entity = repo.save(entity);
		return new CategoryDTO(entity);
	}
	
	
	
	
}
