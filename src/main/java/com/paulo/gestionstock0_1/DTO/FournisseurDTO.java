package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.Fournisseur;
import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class FournisseurDTO {

    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDTO adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;


    private List<CommandeFournisseurDTO> commandeFournisseurDTOS ;

    public static FournisseurDTO fromEntity(Fournisseur fournisseur){
        if (fournisseur == null){
            return null;
        }

        return FournisseurDTO.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
              //  .adresse(fournisseur.getAdresse())
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDTO fournisseurDTO){
        if (fournisseurDTO == null){
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();

        fournisseur.setId(fournisseurDTO.getId());
        fournisseur.setNom(fournisseurDTO.getNom());
        fournisseur.setPrenom(fournisseurDTO.getPrenom());
        fournisseur.setPhoto(fournisseurDTO.getPhoto());
        fournisseur.setMail(fournisseurDTO.getMail());
        fournisseur.setNumTel(fournisseurDTO.getNumTel());
        fournisseur.setIdEntreprise(fournisseurDTO.getIdEntreprise());

        return fournisseur;
    }
}
