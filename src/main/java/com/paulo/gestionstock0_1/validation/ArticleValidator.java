package com.paulo.gestionstock0_1.validation;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDTO articleDTO){
        List <String> errors = new ArrayList<>();

        if (articleDTO == null){

            errors.add("Veillez renseigner le code de l'article");
            errors.add("Veillez renseigner la designation de l'article");
            errors.add("Veillez renseigner le prix unitaire de l'article");
            errors.add("Veillez renseigner le taux de la TVA de l'article");
            errors.add("Veillez renseigner le prix unitaire TTC de l'article");
            errors.add("Veillez sélectionner une catégorie");

            return errors;
        }

        if (!StringUtils.hasLength(articleDTO.getCode())){
            errors.add("Veillez renseigner le code de l'article");
        }

        if (!StringUtils.hasLength(articleDTO.getDesignation())){
            errors.add("Veillez renseigner la designation de l'article");
        }

        if (articleDTO.getTauxUnitaireHt() == null){
            errors.add("Veillez renseigner le prix unitaire de l'article");
        }

        if (articleDTO.getTauxTva() == null){
            errors.add("Veillez renseigner le taux de la TVA de l'article");
        }

        if (articleDTO.getPrixUnitaireTtc() == null){
            errors.add("Veillez renseigner le prix unitaire TTC de l'article");
        }

        if (articleDTO.getCategory() == null){
            errors.add("Veillez sélectionner une catégorie");
        }

        return errors;
    }
}
