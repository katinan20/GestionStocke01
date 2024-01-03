package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.LigneVente;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneVenteDTO {

    private Integer id;

    private ArticleDTO articleDTO;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private VentesDTO ventesDTO;

    private Integer idEntreprise;

    public static LigneVenteDTO fromEntity(LigneVente ligneVente){
        if (ligneVente == null){
            return null;
        }

        return LigneVenteDTO.builder()
                .id(ligneVente.getId())
                .quantite(ligneVente.getQuantite())
                .prixUnitaire(ligneVente.getQuantite())
                .idEntreprise(ligneVente.getIdEntreprise())
                .build();
    }

    public static LigneVente toEntity(LigneVenteDTO ligneVenteDTO){
        if (ligneVenteDTO == null){
            return null;
        }
        LigneVente ligneVente = new LigneVente();

        ligneVente.setIdEntreprise(ligneVenteDTO.getIdEntreprise());
        ligneVente.setId(ligneVenteDTO.getId());
        ligneVente.setQuantite(ligneVenteDTO.getQuantite());


        return ligneVente;
    }
}
