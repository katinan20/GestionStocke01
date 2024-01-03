package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.CategoryDTO;

import java.util.List;

public interface CategorieService {

    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO findById(Integer id);
    CategoryDTO findByCode(String code);
    List<CategoryDTO> findAll();
    CategoryDTO update(CategoryDTO categoryDTO);
    void delete(Integer id);

}
