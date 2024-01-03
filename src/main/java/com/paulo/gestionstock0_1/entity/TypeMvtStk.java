package com.paulo.gestionstock0_1.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TypeMvtStk")
public class TypeMvtStk extends AbstractEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "idEntreprise")
    private Integer idEntreprise;
    @ManyToOne()
    private MvtStk mvtStk;
}
