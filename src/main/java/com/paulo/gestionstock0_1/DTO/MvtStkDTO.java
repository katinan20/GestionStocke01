package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.MvtStk;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@Builder
public class MvtStkDTO {

    private Integer id;

    private Instant dateMvt;

    private BigDecimal quantite;

    private ArticleDTO articleDTO;

    private TypeMvtStk typeMvtStk;

    private Integer idEntreprise;

    public static MvtStkDTO fromEntity(MvtStk mvtStk){
        if (mvtStk == null){
            return null;
        }
        return MvtStkDTO.builder()
                .id(mvtStk.getId())
                .dateMvt(mvtStk.getDateMvt())
                .quantite(mvtStk.getQuantite())
                .idEntreprise(mvtStk.getIdEntreprise())
                .build();
    }


    public static MvtStk toEntity(MvtStkDTO mvtStkDTO){
        if (mvtStkDTO == null){
            return null;
        }

        MvtStk mvtStk = new MvtStk();

        mvtStk.setId(mvtStkDTO.getId());
        mvtStk.setDateMvt(mvtStkDTO.getDateMvt());
        mvtStk.setQuantite(mvtStkDTO.getQuantite());
        mvtStk.setIdEntreprise(mvtStk.getIdEntreprise());

        return mvtStk;
    }
}
