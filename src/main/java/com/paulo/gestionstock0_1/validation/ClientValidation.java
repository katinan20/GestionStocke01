package com.paulo.gestionstock0_1.validation;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidation {
    public static  List<String> validation(ClientDTO clientDTO) {
        List<String> errors = new ArrayList<>();

        if (clientDTO == null){

            errors.add("veillez renseigner le nom du client");
            errors.add("veillez renseigner le prénom du client");
            errors.add("veillez renseigner l'email du client");
            errors.add("veillez renseigner votre  numéro de téléphone");
            errors.add("Veillez renseigner l'adresse client");

            return errors;
        }

        if (!StringUtils.hasLength(clientDTO.getNom())) {
            errors.add("veillez renseigner le nom du client");
        }

        if (!StringUtils.hasLength(clientDTO.getPrenom())) {
            errors.add("veillez renseigner votre prénom ");
        }

        if (!StringUtils.hasLength(clientDTO.getMail())) {
            errors.add("veillez renseigner l'email du client");
        }

        if (!StringUtils.hasLength(clientDTO.getNumTel())) {
            errors.add("veillez renseigner votre  numéro de téléphone");
        }

        if (clientDTO.getAdresse() == null) {
            errors.add("Veillez renseigner l'adresse client");
        } else {
            if (!StringUtils.hasLength(clientDTO.getAdresse().getAdresse1())) {
                errors.add("Le champs 'Adresse 1' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDTO.getAdresse().getVille())) {
                errors.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDTO.getAdresse().getCodePostal())) {
                errors.add("Le champs 'Code postal' est obligatoire");
            }
            if (!StringUtils.hasLength(clientDTO.getAdresse().getPays())) {
                errors.add("Le champs 'pays' est obligatoire");
            }

        }
        return errors;
    }
}
