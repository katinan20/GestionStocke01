package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.FournisseurDTO;

import java.util.List;

public interface FournisseurService {
    FournisseurDTO save(FournisseurDTO fournisseurDTO);
    FournisseurDTO findById(Integer id);
    FournisseurDTO findByNom(String nom);
    List<FournisseurDTO> findAll();
    void delete(Integer id);
}
