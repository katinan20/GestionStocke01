package com.paulo.gestionstock0_1.validation;

import com.paulo.gestionstock0_1.DTO.EntrepriseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validation(EntrepriseDTO entrepriseDTO) {
        List<String> errors = new ArrayList<>();

        if (entrepriseDTO == null){
            errors.add("Veillez enregistrer le nom de l'Entreprise");
            errors.add("Veillez enregistrer le numéro de l'Entreprise");
            errors.add("Veillez enregistrer l'email de l'Entreprise");
            errors.add("Veillez enregistrer l'adresse de l'entreprise");

            return errors;
        }

        if (!StringUtils.hasLength(entrepriseDTO.getNom())){
            errors.add("Veillez enregistrer le nom de l'Entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDTO.getNumTel())){
            errors.add("Veillez enregistrer le numéro de l'Entreprise");
        }

        if (!StringUtils.hasLength(entrepriseDTO.getEmail())){
            errors.add("Veillez enregistrer l'email de l'Entreprise");
        }

        if (entrepriseDTO.getAdresse()==null){
            errors.add("Veillez enregistrer l'adresse de l'entreprise");
        }else {

            if (!StringUtils.hasLength(entrepriseDTO.getAdresse().getAdresse1())){
                errors.add("L'adresse est obligatoire");
            }

            if (!StringUtils.hasLength(entrepriseDTO.getAdresse().getPays())){
                errors.add("Le nom du pays est obligatoire");
            }

            if (!StringUtils.hasLength(entrepriseDTO.getAdresse().getVille())){
                errors.add("Le Nom de la ville est obligatoire");
            }

        }

        return errors;
    }
}
