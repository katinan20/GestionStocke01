package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.UtilisateurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

public interface UtilisateurApi {
    @PostMapping(value = APP_ROOT + "/utilisateur/creat", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDTO save(@RequestBody UtilisateurDTO utilisateurDTO);
    @PostMapping(value = APP_ROOT + "/utilisateur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDTO findById(@PathVariable("id") Integer id);
    @PostMapping(value = APP_ROOT + "/utilisateur/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    UtilisateurDTO findByNom(@PathVariable("nom") String nom);
    @PostMapping(value = APP_ROOT + "/utilisateur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UtilisateurDTO> findAll();
    @DeleteMapping(value = APP_ROOT + "/utilisateur/{idU}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("idU") Integer id);
}
