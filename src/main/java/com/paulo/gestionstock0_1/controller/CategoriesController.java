package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.CategoryDTO;
import com.paulo.gestionstock0_1.controller.api.CategorieApi;
import com.paulo.gestionstock0_1.service.implService.CategorieServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriesController implements CategorieApi {
    private CategorieServiceImp categorieServiceImp;
    @Autowired
    public CategoriesController(CategorieServiceImp categorieServiceImp){
        this.categorieServiceImp = categorieServiceImp;
    }
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO) {
        return categorieServiceImp.save(categoryDTO);
    }

    @Override
    public CategoryDTO findById(Integer id) {
        return categorieServiceImp.findById(id);
    }

    @Override
    public CategoryDTO findByCode(String code) {
        return categorieServiceImp.findByCode(code);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categorieServiceImp.findAll();
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO) {
        return null;
    }
    @Override
    public void delete(Integer id) {
        categorieServiceImp.delete(id);
    }
}
