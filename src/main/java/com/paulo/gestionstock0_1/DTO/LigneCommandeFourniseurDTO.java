package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.LigneCommandeFourniseur;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneCommandeFourniseurDTO {

    private Integer id;

    private ArticleDTO articleDTO;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private CommandeFournisseurDTO commandeFournisseurDTO;

    private Integer idEntreprise;

    public static LigneCommandeFourniseurDTO fromEntity(LigneCommandeFourniseur ligneCommandeFourniseur){
        if (ligneCommandeFourniseur == null){
            return null;
        }
        return LigneCommandeFourniseurDTO.builder()
                .id(ligneCommandeFourniseur.getId())
                .quantite(ligneCommandeFourniseur.getQuantite())
                .prixUnitaire(ligneCommandeFourniseur.getPrixUnitaire())
                .idEntreprise(ligneCommandeFourniseur.getIdEntreprise())
                .build();
    }

    public static LigneCommandeFourniseur toEntity(LigneCommandeFourniseurDTO ligneCommandeFourniseurDTO){
        if (ligneCommandeFourniseurDTO == null){
            return null;
        }
        LigneCommandeFourniseur ligneCommandeFourniseur = new LigneCommandeFourniseur();
        ligneCommandeFourniseur.setId(ligneCommandeFourniseurDTO.getId());
        ligneCommandeFourniseur.setQuantite(ligneCommandeFourniseurDTO.getQuantite());
        ligneCommandeFourniseur.setPrixUnitaire(ligneCommandeFourniseurDTO.getPrixUnitaire());
        ligneCommandeFourniseur.setIdEntreprise(ligneCommandeFourniseurDTO.getIdEntreprise());

        return ligneCommandeFourniseur;
    }
}
