package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

public interface ClientApi {
    @PostMapping(value = APP_ROOT+ "/client/creat", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO save(@RequestBody ClientDTO clientDTO);
    @GetMapping(value = APP_ROOT +"/client/{idclient}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findById(@PathVariable("idclient") Integer id);
    @GetMapping(value = APP_ROOT + "/client/{nom}", produces = MediaType.APPLICATION_JSON_VALUE)
    ClientDTO findByNom(@PathVariable("nom") String nom);
    @GetMapping(value = APP_ROOT +"/client/all", produces = MediaType.APPLICATION_JSON_VALUE)
    List<ClientDTO> findAll();
    @DeleteMapping(value = APP_ROOT +"/client/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void delete(@PathVariable("id") Integer id);
}

