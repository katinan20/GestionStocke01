package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.UtilisateurDTO;
import com.paulo.gestionstock0_1.entity.Utilisateur;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.UtilisateurRepository;
import com.paulo.gestionstock0_1.service.UtilisateurService;
import com.paulo.gestionstock0_1.validation.UtilisateurValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UtlisateurServiceImp implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    public UtlisateurServiceImp(UtilisateurRepository utilisateurRepository){
        this.utilisateurRepository = utilisateurRepository;
    }
    @Override
    public UtilisateurDTO save(UtilisateurDTO utilisateurDTO) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDTO);
        if (!errors.isEmpty()){
            log.error("Utilisateur invalide {} ", utilisateurDTO);
            throw new InvalidEntityException(
                    "L'utilisateur n est pas valid", ErrorCodes.UTILISATEUR_NOT_FOUND, errors
            );
        }
        return UtilisateurDTO.fromEntity(
                utilisateurRepository.save(
                        UtilisateurDTO.toEntity(
                                utilisateurDTO
                        )
                )
        );
    }

    @Override
    public UtilisateurDTO findById(Integer id) {
        if (id == null){
            log.error("L'ID est null");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);

        return Optional.of(UtilisateurDTO.fromEntity(utilisateur.get())).orElseThrow(
                ()-> new EntityNotFoundException(
                                "Aucun utilisateur avec l ID =" + id + "n'a éte trouvé dans la la base de donnée",
                                ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public UtilisateurDTO findByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Nom est invalide");
            return null;
        }
        Optional<Utilisateur> utilisateur = utilisateurRepository.findUtilisateurByNom(nom);
        return Optional.of(UtilisateurDTO.fromEntity(utilisateur.get())).orElseThrow(
                ()->new EntityNotFoundException(
                        "Aucun utilisateur avec le nom =" +nom+ "n a été trouvé dans la base de donnée",
                        ErrorCodes.UTILISATEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List<UtilisateurDTO> findAll() {
        return utilisateurRepository.findAll()
                .stream()
                .map(UtilisateurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        utilisateurRepository.deleteById(id);
    }
}
