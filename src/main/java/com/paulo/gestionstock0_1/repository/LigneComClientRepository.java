package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.entity.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneComClientRepository extends JpaRepository<LigneCommandeClient, Integer> {
}
