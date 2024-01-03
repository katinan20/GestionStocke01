package com.paulo.gestionstock0_1.validation;

import com.paulo.gestionstock0_1.DTO.FournisseurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidation {
    public static List<String> validate(FournisseurDTO fournisseurDTO){
        List <String> errors = new ArrayList<>();

        if (fournisseurDTO == null){

            errors.add("veillez renseigner le nom du fournisseur");
            errors.add("veillez renseigner le prénom du fournisseur");
            errors.add("veillez renseigner l'email du fournisseur");
            errors.add("veillez renseigner votre  numéro de téléphone");
            errors.add("Veillez renseigner l'adresse fournisseur");

            return errors;
        }

        if (!StringUtils.hasLength(fournisseurDTO.getNom())) {
            errors.add("veillez renseigner le nom du fournisseur");
        }

        if (!StringUtils.hasLength(fournisseurDTO.getPrenom())) {
            errors.add("veillez renseigner votre fournisseur ");
        }

        if (!StringUtils.hasLength(fournisseurDTO.getMail())) {
            errors.add("veillez renseigner l'email du fournisseur");
        }

        if (!StringUtils.hasLength(fournisseurDTO.getNumTel())) {
            errors.add("veillez renseigner votre  numéro de téléphone");
        }

        if (fournisseurDTO.getAdresse() == null) {
            errors.add("Veillez renseigner l'adresse fournisseur");
        } else {
            if (!StringUtils.hasLength(fournisseurDTO.getAdresse().getAdresse1())) {
                errors.add("Le champs 'Adresse 1' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDTO.getAdresse().getVille())) {
                errors.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDTO.getAdresse().getCodePostal())) {
                errors.add("Le champs 'Code postal' est obligatoire");
            }
            if (!StringUtils.hasLength(fournisseurDTO.getAdresse().getPays())) {
                errors.add("Le champs 'pays' est obligatoire");
            }

        }

        return errors;
    }
}
