package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import com.paulo.gestionstock0_1.entity.Client;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.ClientRepository;
import com.paulo.gestionstock0_1.service.ClientService;
import com.paulo.gestionstock0_1.validation.ClientValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImp implements ClientService {
    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        List<String> errors = ClientValidation.validation(clientDTO);
        if(!errors.isEmpty()){
            log.error("Clients invalid {}", clientDTO);
            throw new InvalidEntityException("Le client n'est pas valid", ErrorCodes.CLIENT_NOT_FOUND, errors);
        }
        return ClientDTO.fromEntity(
                clientRepository.save(
                        ClientDTO.toEntity(clientDTO)
                )
        );
    }

    @Override
    public ClientDTO findById(Integer id) {
        if (id == null){
            log.error("Client ID est null");
            return null;
        }
        Optional<Client> client = clientRepository.findById(id);

        return Optional.of(ClientDTO.fromEntity(client.get())).orElseThrow(
                ()->new EntityNotFoundException(
                        "Aucun client avec  l'ID = "+ id +" n'a été trouvé dans la base de donnée",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public ClientDTO findByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("le nom du client est invalid");
            return null;
        }
        Optional<Client> client = clientRepository.findClientByNom(nom);

        return Optional.of(ClientDTO.fromEntity(client.get())).orElseThrow(
                ()->new EntityNotFoundException(
                        "Aucun client avec  le NOM = "+ nom +" n'a été trouvé dans la base de donnée",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public List<ClientDTO> findAll() {

        return clientRepository.findAll().stream()
                .map(ClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Client ID est null");
            return ;
        }
        clientRepository.deleteById(id);
    }
}
