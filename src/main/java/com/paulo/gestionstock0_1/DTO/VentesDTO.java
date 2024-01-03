package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.Ventes;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;


@Data
@Builder
public class VentesDTO {

    private Integer id;

    private String code;

    private Instant dateVente;

    private String commentaire;

    private Integer idEntreprise;

    private List<LigneVenteDTO> ligneVenteDTOS;
    public static VentesDTO fromEntity(Ventes ventes){
        if (ventes == null){
            return null;
        }
        return VentesDTO.builder()
                .id(ventes.getId())
                .code(ventes.getCode())
                .dateVente(ventes.getDateVente())
                .commentaire(ventes.getCommentaire())
                .idEntreprise(ventes.getIdEntreprise())
                .build();
    }

    public static Ventes toEntity(VentesDTO ventesDTO) {
        if (ventesDTO == null) {
            return null;
        }

        Ventes ventes = new Ventes();

        ventes.setId(ventesDTO.getId());
        ventes.setCode(ventesDTO.getCode());
        ventes.setDateVente(ventesDTO.getDateVente());
        ventes.setCommentaire(ventesDTO.getCommentaire());
        ventes.setIdEntreprise(ventesDTO.getIdEntreprise());

        return ventes;
    }
}
