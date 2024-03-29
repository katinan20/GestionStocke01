package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VentesRepository extends JpaRepository<Ventes, Integer> {

    Optional<Ventes> findVenteCodeByCode(String code);
}
