package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.CommandeFournisseur;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeFournisseurDTO {
    private Integer id;

    private String code;

    private Instant dateCommande;

    private FournisseurDTO fournisseur;

    private Integer idEntreprise;


    private List<LigneCommandeFourniseurDTO> ligneCommandeFourniseurDTOS;

    public static CommandeFournisseurDTO fromEntity(CommandeFournisseur commandeFournisseur){
        if (commandeFournisseur == null){
            return null;
        }
        return CommandeFournisseurDTO.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .dateCommande(commandeFournisseur.getDateCommande())
                .idEntreprise(commandeFournisseur.getIdEntreprise())
                .build();
    }

    public static CommandeFournisseur toEntity(CommandeFournisseurDTO commandeClientDTO){
        if (commandeClientDTO == null){
            return null;
        }
        CommandeFournisseur commandeFournisseur  = new CommandeFournisseur();

        commandeFournisseur.setId(commandeClientDTO.getId());
        commandeFournisseur.setCode(commandeClientDTO.getCode());
        commandeFournisseur.setDateCommande(commandeClientDTO.getDateCommande());
        commandeFournisseur.setIdEntreprise(commandeClientDTO.getIdEntreprise());


        return commandeFournisseur;
    }
}
