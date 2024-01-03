package com.paulo.gestionstock0_1.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "article")
public class Article  extends AbstractEntity{

    @Column(name = "codeArticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "tauxUnitaireHt")
    private BigDecimal tauxUnitaireHt;

    @Column(name = "tauxTva")
    private BigDecimal tauxTva;

    @Column(name = "prixUnitaire")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @Column(name = "photo")
    private String photo;


    @ManyToOne
    private Category category;

    @ManyToOne
    private Entreprise entreprise;

    @OneToMany(mappedBy = "article")
    private List<MvtStk> mvtStks;

    @OneToMany(mappedBy = "article")
    private List<LigneVente>  ligneVente;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient>  ligneCommandeClient;

    @OneToMany(mappedBy = "article")
    private  List<LigneCommandeFourniseur>  ligneCommandeFourniseur;

}
