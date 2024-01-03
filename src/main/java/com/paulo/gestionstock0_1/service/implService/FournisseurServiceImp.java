package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.FournisseurDTO;
import com.paulo.gestionstock0_1.entity.Fournisseur;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.FournisseurRepository;
import com.paulo.gestionstock0_1.service.FournisseurService;
import com.paulo.gestionstock0_1.validation.FournisseurValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FournisseurServiceImp  implements FournisseurService {
    private FournisseurRepository fournisseurRepository;
    @Autowired
    public FournisseurServiceImp(FournisseurRepository fournisseurRepository){
        this.fournisseurRepository = fournisseurRepository;
    }
    @Override
    public FournisseurDTO save(FournisseurDTO fournisseurDTO) {
        List<String> errors = FournisseurValidation.validate(fournisseurDTO);
        if (!errors.isEmpty()){
            log.error("Fournisseur not valide {} ", fournisseurDTO);
            throw new InvalidEntityException("Fournisseur Invalide", ErrorCodes.FOURNISEUR_NOT_FOUND, errors);
        }
        return FournisseurDTO.fromEntity(
                fournisseurRepository.save(
                        FournisseurDTO.toEntity(fournisseurDTO)
                )
        );
    }

    @Override
    public FournisseurDTO findById(Integer id) {
        if (id == null){
            log.error("ID n'est pas valide ");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return Optional.of(FournisseurDTO.fromEntity(fournisseur.get())).orElseThrow(
                ()-> new EntityNotFoundException(
                        "Aucun fournisseur avec l ID "+ id + "n a été trouvé dans la base de donné",
                        ErrorCodes.FOURNISEUR_NOT_FOUND
                )
        );
    }

    @Override
    public FournisseurDTO findByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Le nom n est pas valide");
            return null;
        }
        Optional<Fournisseur> fournisseur = fournisseurRepository.findFournisseurByNom(nom);
        return Optional.of(FournisseurDTO.fromEntity(fournisseur.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun fournisseur de nom = "+ nom + "n a été trouvé dans la base de donnée",
                        ErrorCodes.FOURNISEUR_NOT_FOUND
                )
        );
    }

    @Override
    public List <FournisseurDTO> findAll() {
        return fournisseurRepository.findAll()
                .stream()
                .map(FournisseurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);
    }
}
