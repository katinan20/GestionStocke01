package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.UtilisateurDTO;

import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO save(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO findById(Integer id);
    UtilisateurDTO findByNom(String nom);
    List<UtilisateurDTO> findAll();
    void delete(Integer id);
}
