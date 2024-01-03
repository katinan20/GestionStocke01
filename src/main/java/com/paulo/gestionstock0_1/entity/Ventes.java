package com.paulo.gestionstock0_1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Table(name = "vente")
public class Ventes  extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;

    @Column(name = "dateVente")
    private Instant dateVente;

    @Column(name = "commentaire")
    private String commentaire;

    @OneToMany(mappedBy = "ventes")
    private List<LigneVente> ligneVentes;

}
