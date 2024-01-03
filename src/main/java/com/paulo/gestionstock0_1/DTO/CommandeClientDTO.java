package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.CommandeClient;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class CommandeClientDTO {
    private Integer id;

    private String code;

    private Instant dateCommande;

    private ClientDTO client;

    private Integer idEntreprise;

    private List<LigneCommandeClientDTO> ligneCommandeClients;

    public static CommandeClientDTO fromEntity(CommandeClient commandeClient){
        if (commandeClient == null){
            return null;
        }
        return CommandeClientDTO.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .client(ClientDTO.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDTO commandeClientDTO){
        if (commandeClientDTO == null){
            return null;
        }
        CommandeClient commandeClient = new CommandeClient();

        commandeClient.setId(commandeClientDTO.getId());
        commandeClient.setCode(commandeClientDTO.getCode());
        commandeClient.setDateCommande(commandeClientDTO.getDateCommande());
        commandeClient.setIdEntreprise(commandeClientDTO.getIdEntreprise());

        return commandeClient;
    }

}
