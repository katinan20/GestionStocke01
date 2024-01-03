package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.CategoryDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

public interface CategorieApi {
    @PostMapping(value = APP_ROOT + "/categories/creat", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO save(@RequestBody CategoryDTO categoryDTO);
    @GetMapping(value = APP_ROOT + "/categories/{idc}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO findById(@PathVariable("idc") Integer id);
    @GetMapping(value = APP_ROOT+ "/categories/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO findByCode(@PathVariable("code") String code);
    @GetMapping(value = APP_ROOT +"/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<CategoryDTO> findAll();
    @PostMapping(value = APP_ROOT +"/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CategoryDTO update(@RequestBody CategoryDTO categoryDTO);
    @DeleteMapping(value = APP_ROOT +"/categories/{idcategories}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idcategories") Integer id);
}
