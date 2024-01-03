package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Optional<Entreprise> findEntrepriseByNom(String nom);
}
