package com.felipeveiga.catalog.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.felipeveiga.catalog.entities.dto.CategoryDTO;
import com.felipeveiga.catalog.services.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		List<CategoryDTO> categoriesDTO = service.findAll();
		return ResponseEntity.ok().body(categoriesDTO);
	}
	
}