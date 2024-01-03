package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.EntrepriseDTO;

import java.util.List;

public interface EntrepriseService {
    EntrepriseDTO save(EntrepriseDTO entrepriseDTO);
    EntrepriseDTO findById(Integer id);
    EntrepriseDTO findByNom(String nom);
    List<EntrepriseDTO> findAll();
    void delete(Integer id);
}
