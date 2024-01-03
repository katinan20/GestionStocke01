package com.paulo.gestionstock0_1.validation;

import  com.paulo.gestionstock0_1.DTO.CategoryDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> validate(CategoryDTO categoryDTO){
        List <String> errors = new ArrayList<>();
        if (categoryDTO == null || !StringUtils.hasLength(categoryDTO.getCode())){
            errors.add("Veillez renseigner le code de la catégorie");
        }
        return errors;
    }
}
