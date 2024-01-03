package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Optional<Utilisateur> findUtilisateurByNom(String nom);
}
