package com.paulo.gestionstock0_1.validation;

import com.paulo.gestionstock0_1.DTO.UtilisateurDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDTO utilisateurDTO){
        List<String> erreurs = new ArrayList<>();

        if (utilisateurDTO == null){
            erreurs.add("Veillez renseigner le nom de l'utilisateur");
            erreurs.add("Veillez renseigner le prénom de l'utilisateur");
            erreurs.add("Veillez renseigner l'email de l'utilisateur");
            erreurs.add("Veillez renseigner le mode de passe de l'utilisateur");
            erreurs.add("Veillez renseigner l'adresse d'utilisateur");

            return erreurs;
        }

        if (!StringUtils.hasLength(utilisateurDTO.getNom()) ){
            erreurs.add("Veillez renseigner le nom de l'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDTO.getPrenom()) ){
            erreurs.add("Veillez renseigner le prénom de l'utilisateur");
        }

        if (!StringUtils.hasLength(utilisateurDTO.getMail()) ){
            erreurs.add("Veillez renseigner l'email de l'utilisateur");
        }

        if (!StringUtils.hasLength(utilisateurDTO.getMotDePasse()) ){
            erreurs.add("Veillez renseigner le mode de passe de l'utilisateur");
        }

        if (utilisateurDTO.getDateNaissance() == null){
            erreurs.add("Veillez renseigner la date de naissance d'utilisateur");
        }

        if (utilisateurDTO.getAdresse() == null){
            erreurs.add("Veillez renseigner l'adresse d'utilisateur");
        }else {
            if (!StringUtils.hasLength(utilisateurDTO.getAdresse().getAdresse1()) ){
                erreurs.add("Le champs 'Adresse 1' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDTO.getAdresse().getVille()) ){
                erreurs.add("Le champs 'Ville' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDTO.getAdresse().getCodePostal()) ){
                erreurs.add("Le champs 'Code postal' est obligatoire");
            }
            if (!StringUtils.hasLength(utilisateurDTO.getAdresse().getPays()) ){
                erreurs.add("Le champs 'pays' est obligatoire");
            }
        }

        return erreurs;
    }

}
