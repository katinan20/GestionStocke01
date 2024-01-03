package com.paulo.gestionstock0_1.DTO;


import com.paulo.gestionstock0_1.entity.Utilisateur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class UtilisateurDTO {
    private Integer id;

    private String nom;

    private String prenom;

    private String mail;

    private Instant dateNaissance;

    private String motDePasse;

    private AdresseDTO adresse;

    private String photo;

    private String numTel;

    private EntrepriseDTO entrepriseDTO;

    private List<RolesDTO> rolesDTOS;

    private Integer idEntreprise;

    public static UtilisateurDTO fromEntity(Utilisateur utilisateur){
        if (utilisateur == null){
            return null;
        }
        return UtilisateurDTO.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .mail(utilisateur.getMail())
                .dateNaissance(utilisateur.getDateNaissance())
                .motDePasse(utilisateur.getMotDePasse())
              //  .adresse(utilisateur.getAdresse())
                .photo(utilisateur.getPhoto())
              //  .numTel(utilisateur.getNumtel)
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDTO utilisateurDTO){
        if (utilisateurDTO == null){
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateurDTO.getId());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setMail(utilisateurDTO.getMail());
        utilisateur.setDateNaissance(utilisateurDTO.getDateNaissance());
        utilisateur.setMotDePasse(utilisateurDTO.getMotDePasse());
        utilisateur.setPhoto(utilisateurDTO.getPhoto());

        return utilisateur;
    }
}
