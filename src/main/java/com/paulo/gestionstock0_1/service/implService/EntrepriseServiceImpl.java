package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.ClientDTO;
import com.paulo.gestionstock0_1.DTO.EntrepriseDTO;
import com.paulo.gestionstock0_1.entity.Client;
import com.paulo.gestionstock0_1.entity.Entreprise;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.EntrepriseRepository;
import com.paulo.gestionstock0_1.service.EntrepriseService;
import com.paulo.gestionstock0_1.validation.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepository entrepriseRepository;
    @Autowired
    public EntrepriseServiceImpl(EntrepriseRepository entrepriseRepository){
        this.entrepriseRepository = entrepriseRepository;
    }
    @Override
    public EntrepriseDTO save(EntrepriseDTO entrepriseDTO) {
        List<String> errors = EntrepriseValidator.validation(entrepriseDTO);
        if (!errors.isEmpty()){
            log.error("Entreprise invalid {}", entrepriseDTO);
            throw new InvalidEntityException(
                    "Entreprise n 'est pas valid", ErrorCodes.ENTREPRISE_NOT_FOUND, errors
            );
        }
        return EntrepriseDTO.fromEntity(
                entrepriseRepository.save(
                        EntrepriseDTO.toEntity(entrepriseDTO)
                )
        );
    }

    @Override
    public EntrepriseDTO findById(Integer id) {
        if (id == null){
            log.error("Entreprise ID est null");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findById(id);

        return Optional.of(EntrepriseDTO.fromEntity(entreprise.get())).orElseThrow(
                ()->new EntityNotFoundException(
                        "Aucun Entreprise avec  l'ID = "+ id +" n'a été trouvé dans la base de donnée",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public EntrepriseDTO findByNom(String nom) {

        if (!StringUtils.hasLength(nom)){
            log.error("Nom de l'entreprise est invalid");
            return null;
        }
        Optional<Entreprise> entreprise = entrepriseRepository.findEntrepriseByNom(nom);

        return Optional.of(EntrepriseDTO.fromEntity(entreprise.get())).orElseThrow(
                ()->new EntityNotFoundException(
                        "Aucun Entreprise avec  le NOM = "+ nom +" n'a été trouvé dans la base de donnée",
                        ErrorCodes.CLIENT_NOT_FOUND
                )
        );
    }

    @Override
    public List<EntrepriseDTO> findAll() {
        return entrepriseRepository.findAll()
                .stream()
                .map(EntrepriseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id==null){
            log.error("Entreprise ID est null");
            return ;
        }
        entrepriseRepository.deleteById(id);
    }
}
