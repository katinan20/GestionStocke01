package com.paulo.gestionstock0_1.DTO;

import com.paulo.gestionstock0_1.entity.Article;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Builder
public class ArticleDTO {
    private Integer id;

    private String code;

    private String designation;

    private BigDecimal tauxUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private CategoryDTO category;

    private EntrepriseDTO entreprise;

    private Integer idEntreprise;

    public static ArticleDTO fromEntity(Article article){
        if (article == null){
            return null;
        }

        return ArticleDTO.builder()
                .id(article.getId())
                .code(article.getCodeArticle())
                .designation(article.getDesignation())
                .prixUnitaireTtc(article.getPrixUnitaireTtc())
                .photo(article.getPhoto())
                .tauxUnitaireHt(article.getTauxUnitaireHt())
                .tauxTva(article.getTauxTva())
                .idEntreprise(article.getIdEntreprise())
                .build();

    }

    public static Article toEntity(ArticleDTO articleDTO){
        if (articleDTO == null){
            return null;
        }
        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setCodeArticle(articleDTO.getCode());
        article.setDesignation(articleDTO.getDesignation());
        article.setPrixUnitaireTtc(articleDTO.getPrixUnitaireTtc());
        article.setPhoto(articleDTO.getPhoto());
        article.setTauxTva(articleDTO.getTauxTva());
        article.setTauxUnitaireHt(articleDTO.getTauxUnitaireHt());
        article.setIdEntreprise(articleDTO.getIdEntreprise());

        return article;
    }

}
