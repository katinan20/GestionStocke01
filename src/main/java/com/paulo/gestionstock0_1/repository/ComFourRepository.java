package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.DTO.CommandeFournisseurDTO;
import com.paulo.gestionstock0_1.entity.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComFourRepository extends JpaRepository<CommandeFournisseur, Integer> {
   Optional<CommandeFournisseur>  findCommadeFourByCode(String codeArticle);
}
