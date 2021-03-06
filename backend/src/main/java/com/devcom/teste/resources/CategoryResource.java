package com.devcom.teste.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devcom.teste.dto.CategoryDTO;
import com.devcom.teste.services.CategoryService;
import com.devcom.teste.services.exceptions.EntityNotFoundException;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> list = categoryService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {

		CategoryDTO dto = categoryService.findById(id);
		return ResponseEntity.ok().body(dto);
	
	}

}
