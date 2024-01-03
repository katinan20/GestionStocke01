package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import com.paulo.gestionstock0_1.controller.api.ClientApi;
import com.paulo.gestionstock0_1.service.implService.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController implements ClientApi {
    private ClientServiceImp clientServiceImp;
    @Autowired
    public ClientController(ClientServiceImp clientServiceImp){
        this.clientServiceImp = clientServiceImp;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        return clientServiceImp.save(clientDTO);
    }

    @Override
    public ClientDTO findById(Integer id) {
        return clientServiceImp.findById(id);
    }

    @Override
    public ClientDTO findByNom(String nom) {
        return clientServiceImp.findByNom(nom);
    }

    @Override
    public List<ClientDTO> findAll() {
        return clientServiceImp.findAll();
    }

    @Override
    public void delete(Integer id) {
        clientServiceImp.delete(id);
    }
}
