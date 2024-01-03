package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.LigneVenteDTO;
import com.paulo.gestionstock0_1.DTO.VentesDTO;
import com.paulo.gestionstock0_1.entity.Article;
import com.paulo.gestionstock0_1.entity.LigneVente;
import com.paulo.gestionstock0_1.entity.Ventes;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.ArticleRepository;
import com.paulo.gestionstock0_1.repository.LigneVenteRepository;
import com.paulo.gestionstock0_1.repository.VentesRepository;
import com.paulo.gestionstock0_1.service.VenteService;
import com.paulo.gestionstock0_1.validation.VenteValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VenteServiceImp implements VenteService {
    private VentesRepository ventesRepository;
    private LigneVenteRepository ligneVenteRepository;
    private ArticleRepository articleRepository;

    @Autowired
    public VenteServiceImp(
            VentesRepository ventesRepository
            ,LigneVenteRepository ligneVenteRepository
            ,ArticleRepository articleRepository)
    {
        this.ventesRepository = ventesRepository;
        this.ligneVenteRepository = ligneVenteRepository;
        this.articleRepository = articleRepository;
    }

    @Override
    public VentesDTO save(VentesDTO ventesDTO) {
        List<String> errors = VenteValidator.validate(ventesDTO);
        if (!errors.isEmpty()){
            log.error("la Vente n est pas invalide {}", errors);
            throw new InvalidEntityException(
                    "vente invalide ", ErrorCodes.VENTES_NOT_FOUND, errors
            );
        }

        List<String> articleErrors = new ArrayList<>();
        ventesDTO.getLigneVenteDTOS().forEach(
                ligVentArticle ->{
                    Optional<Article> article = articleRepository.findById(ligVentArticle.getArticleDTO().getId());
                    if (article.isEmpty()){
                        articleErrors.add("Aucun article avec l ID "+ ligVentArticle.getArticleDTO().getId()+ "n a été trouvé dans la base de donné");
                    }
                }
        );

        if (!articleErrors.isEmpty()){
            log.error("aucun article n a été trouvé dans la base de donnée {}", errors);
            throw new InvalidEntityException(
                    "un ou plusieurs articles n'ont pas été trouvé dans la base de donnée ", ErrorCodes.ARTICLE_NOT_FOUND, errors
            );
        }

        Ventes saveventes = ventesRepository.save(VentesDTO.toEntity(ventesDTO));
        ventesDTO.getLigneVenteDTOS().forEach(
                ligneVenteDTO -> {
                    LigneVente ligneVente = LigneVenteDTO.toEntity(ligneVenteDTO);
                    ligneVente.setVentes(saveventes);
                    ligneVenteRepository.save(ligneVente);
                }
        );
        return VentesDTO.fromEntity(saveventes);
    }

    @Override
    public VentesDTO findById(Integer id) {
        if (id == null){
            log.warn("");
            return null;
        }
        return ventesRepository.findById(id)
                .map(VentesDTO::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucune vente n a ete trouvé dans la base de donnée",
                                ErrorCodes.VENTES_NOT_FOUND
                        )
                );
    }

    @Override
    public VentesDTO findByCode(String code) {
        if (!StringUtils.hasLength(code)){
            log.error("Vente code null");
            return null;
        }
        return ventesRepository.findVenteCodeByCode(code)
                .map(VentesDTO::fromEntity)
                .orElseThrow(
                        ()-> new EntityNotFoundException(
                                "Aucune vente n a ete trouvé avec le code "+code+" dans la base de donnée",
                                ErrorCodes.VENTES_NOT_FOUND
                        )
                );
    }

    @Override
    public List<VentesDTO> findAll() {
        return ventesRepository.findAll()
                .stream()
                .map(VentesDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("Vente code null");
            return;
        }
        ventesRepository.deleteById(id);
    }
}
