package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FournisseurRepository extends JpaRepository <Fournisseur, Integer>{
    Optional<Fournisseur> findFournisseurByNom(String nom);
}
