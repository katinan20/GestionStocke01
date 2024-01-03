package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.FournisseurDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;
public interface FournisseurApi {
    @PostMapping(value = APP_ROOT + "/fournisseur/creat", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO save(@RequestBody FournisseurDTO fournisseurDTO);
    @GetMapping(value = APP_ROOT + "/fournisseur/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO findById(@PathVariable("id") Integer id);
    @GetMapping(value = APP_ROOT +"/fournisseur/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    FournisseurDTO findByNom(@PathVariable("nom") String nom);
    @GetMapping(value = APP_ROOT +"/fournisseur/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<FournisseurDTO> findAll();
    @DeleteMapping(value = APP_ROOT +"/fournisseur/{idf}")
    void delete(@PathVariable("idf") Integer id);
}