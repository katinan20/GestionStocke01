package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.CommandeFournisseurDTO;

import java.util.List;

public interface CommandeFourService {
    CommandeFournisseurDTO save(CommandeFournisseurDTO cfs);
    CommandeFournisseurDTO findById(Integer id);
    CommandeFournisseurDTO findByCode(String codeArticle);
    List<CommandeFournisseurDTO> findAll();
    void delete(Integer id);
}
