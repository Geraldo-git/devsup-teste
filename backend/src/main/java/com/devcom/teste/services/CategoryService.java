package com.devcom.teste.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devcom.teste.dto.CategoryDTO;
import com.devcom.teste.entities.Category;
import com.devcom.teste.repositories.CategoryRepository;
import com.devcom.teste.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = categoryRepository.findAll();
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = categoryRepository.findById(id);
		Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found !"));
		return  new CategoryDTO(entity);
	}

}
