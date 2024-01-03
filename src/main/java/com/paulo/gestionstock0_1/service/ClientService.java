package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

public interface ClientService {
    ClientDTO save(ClientDTO clientDTO);
    ClientDTO findById(Integer id);
    ClientDTO findByNom(String nom);
    List<ClientDTO> findAll();
    void delete(Integer id);
}
