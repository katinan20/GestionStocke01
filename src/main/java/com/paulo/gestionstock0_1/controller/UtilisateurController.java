package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.UtilisateurDTO;
import com.paulo.gestionstock0_1.controller.api.UtilisateurApi;
import com.paulo.gestionstock0_1.repository.UtilisateurRepository;
import com.paulo.gestionstock0_1.service.implService.UtlisateurServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UtilisateurController implements UtilisateurApi {
    private UtlisateurServiceImp utlisateurServiceImp;
    @Autowired
    public UtilisateurController( UtlisateurServiceImp utlisateurServiceImp){
        this.utlisateurServiceImp = utlisateurServiceImp;
    }
    @Override
    public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
        return utlisateurServiceImp.save(utilisateurDTO);
    }

    @Override
    public UtilisateurDTO findById(Integer id) {
        return utlisateurServiceImp.findById(id);
    }

    @Override
    public UtilisateurDTO findByNom(String nom) {
        return utlisateurServiceImp.findByNom(nom);
    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return utlisateurServiceImp.findAll();
    }

    @Override
    public void delete(Integer id) {
        utlisateurServiceImp.delete(id);
    }
}
