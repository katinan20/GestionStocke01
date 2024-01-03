package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.EntrepriseDTO;
import com.paulo.gestionstock0_1.controller.api.EntrepriseApi;
import com.paulo.gestionstock0_1.service.implService.EntrepriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrepriseController implements EntrepriseApi {
    private EntrepriseServiceImpl entrepriseService;

    @Autowired
    public EntrepriseController(EntrepriseServiceImpl entrepriseService){
        this.entrepriseService = entrepriseService;
    }
    @Override
    public EntrepriseDTO save(EntrepriseDTO entrepriseDTO) {
        return entrepriseService.save(entrepriseDTO);
    }

    @Override
    public EntrepriseDTO findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public EntrepriseDTO findByNom(String nom) {
        return entrepriseService.findByNom(nom);
    }

    @Override
    public List<EntrepriseDTO> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }
}
