package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.EntrepriseDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

public interface EntrepriseApi {
    @PostMapping(value = APP_ROOT +"/entreprise/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO save(@RequestBody EntrepriseDTO entrepriseDTO);
    @GetMapping(value = APP_ROOT + "/entreprise/{identreprise}", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO findById(@PathVariable("identreprise") Integer id);
    @GetMapping(value = APP_ROOT +"/entreprise/nom", produces = MediaType.APPLICATION_JSON_VALUE)
    EntrepriseDTO findByNom(@PathVariable("nom") String nom);
    @GetMapping(value = APP_ROOT +"/entreprise/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<EntrepriseDTO> findAll();
    @DeleteMapping(value = APP_ROOT +"/entreprise/delete", produces = MediaType.APPLICATION_JSON_VALUE )
    void delete(Integer id);
}
