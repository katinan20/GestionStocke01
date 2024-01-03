package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.CommandeClientDTO;

import java.util.List;

public interface CommandClientService {
    CommandeClientDTO save(CommandeClientDTO articleDTO);
    CommandeClientDTO findById(Integer id);
    CommandeClientDTO findByCode(String codeArticle);
    List<CommandeClientDTO> findAll();
    void delete(Integer id);
}
