package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.LigneCommandeFourniseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneComFourRepository extends JpaRepository<LigneCommandeFourniseur, Integer> {
}
