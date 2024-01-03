package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.FournisseurDTO;
import com.paulo.gestionstock0_1.controller.api.FournisseurApi;
import com.paulo.gestionstock0_1.service.FournisseurService;
import com.paulo.gestionstock0_1.service.implService.FournisseurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurServiceImp fournisseur;
    @Autowired
    public FournisseurController(FournisseurServiceImp fournisseur){
        this.fournisseur = fournisseur;
    }
    @Override
    public FournisseurDTO save(FournisseurDTO fournisseurDTO) {
        return fournisseur.save(fournisseurDTO);
    }

    @Override
    public FournisseurDTO findById(Integer id) {
        return fournisseur.findById(id);
    }

    @Override
    public FournisseurDTO findByNom(String nom) {
        return fournisseur.findByNom(nom);
    }

    @Override
    public List<FournisseurDTO> findAll() {
        return fournisseur.findAll();
    }

    @Override
    public void delete(Integer id) {
        fournisseur.delete(id);
    }
}
