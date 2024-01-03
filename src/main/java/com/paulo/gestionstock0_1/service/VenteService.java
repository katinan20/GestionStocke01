package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.VentesDTO;

import java.util.List;

public interface VenteService {
    VentesDTO save(VentesDTO ventesDTO);
    VentesDTO findById(Integer id);
    VentesDTO findByCode(String code);
    List<VentesDTO> findAll();
    void delete(Integer id);
}
