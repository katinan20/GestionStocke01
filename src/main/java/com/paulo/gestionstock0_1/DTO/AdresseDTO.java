package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDTO {

    private Integer id;

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostal;

    private String pays;


    public static AdresseDTO fromEntty(Adresse adresse){
        if (adresse == null){
            return null;
        }
        return AdresseDTO.builder()
                .adresse1(adresse.getAdresse1())
                .adresse2(adresse.getAdresse2())
                .codePostal(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
    }

    public static Adresse toEntity(AdresseDTO adresseDTO){
        if (adresseDTO == null){
            return null;
        }

        Adresse adresse3 = new Adresse();
        adresse3.setAdresse1(adresseDTO.getAdresse1());
        adresse3.setAdresse2(adresseDTO.getAdresse2());
        adresse3.setCodePostal(adresseDTO.getCodePostal());
        adresse3.setVille(adresseDTO.getVille());
        adresse3.setPays(adresseDTO.getPays());

        return adresse3;
    }

}
