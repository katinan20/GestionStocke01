package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.LigneCommandeClient;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class LigneCommandeClientDTO {
    private Integer id;

    private ArticleDTO articleDTO;

    private CommandeClientDTO commandeClientDTO;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;

    public static LigneCommandeClientDTO fromEntity(LigneCommandeClient ligneCommandeClient){
        if (ligneCommandeClient == null){
            return null;
        }
        return LigneCommandeClientDTO.builder()
                .id(ligneCommandeClient.getId())
                .quantite(ligneCommandeClient.getQuantite())
                .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
                .idEntreprise(ligneCommandeClient.getIdEntreprise())
                .build();
    }

    public static LigneCommandeClient toEntity(LigneCommandeClientDTO ligneCommandeClientDTO){
        if (ligneCommandeClientDTO == null){
            return null;
        }
        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();

        ligneCommandeClient.setId(ligneCommandeClientDTO.getId());
        ligneCommandeClient.setQuantite(ligneCommandeClientDTO.getQuantite());
        ligneCommandeClient.setPrixUnitaire(ligneCommandeClientDTO.getPrixUnitaire());
        ligneCommandeClient.setIdEntreprise(ligneCommandeClientDTO.getIdEntreprise());

        return ligneCommandeClient;
    }

}
