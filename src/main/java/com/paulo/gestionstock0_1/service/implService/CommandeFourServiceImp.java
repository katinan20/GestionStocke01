package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.CommandeFournisseurDTO;
import com.paulo.gestionstock0_1.DTO.LigneCommandeFourniseurDTO;
import com.paulo.gestionstock0_1.entity.Article;
import com.paulo.gestionstock0_1.entity.CommandeFournisseur;
import com.paulo.gestionstock0_1.entity.Fournisseur;
import com.paulo.gestionstock0_1.entity.LigneCommandeFourniseur;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.ArticleRepository;
import com.paulo.gestionstock0_1.repository.ComFourRepository;
import com.paulo.gestionstock0_1.repository.FournisseurRepository;
import com.paulo.gestionstock0_1.repository.LigneComFourRepository;
import com.paulo.gestionstock0_1.service.CommandeFourService;
import com.paulo.gestionstock0_1.validation.ComFourValidator;
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
public class CommandeFourServiceImp implements CommandeFourService {
    private LigneComFourRepository ligneComFourRepository;
    private ArticleRepository articleRepository;
    private FournisseurRepository fournisseurRepository;
    private ComFourRepository comFourRepository;

    @Autowired
    public CommandeFourServiceImp(LigneComFourRepository ligneComFourRepository,
                                  ArticleRepository articleRepository,
                                  FournisseurRepository fournisseurRepository,
                                  ComFourRepository comFourRepository) {
        this.ligneComFourRepository = ligneComFourRepository;
        this.articleRepository = articleRepository;
        this.fournisseurRepository = fournisseurRepository;
        this.comFourRepository = comFourRepository;
    }

    @Override
    public CommandeFournisseurDTO save(CommandeFournisseurDTO cfs) {
        List<String> errors = ComFourValidator.validate(cfs);

        if (!errors.isEmpty()){
            log.error("Commande fournisseur invalide");
            throw new InvalidEntityException(
                    "La commande fournisseur n est pas valide", ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND,
                    errors
            );
        }
        /* verifier si le fournisseur est dans la base de donnée **/
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(cfs.getFournisseur().getId());

        if (fournisseur.isEmpty()){
            log.error("le fournisseur avec l ID {} n existe pas ", cfs.getFournisseur().getId());
            throw new EntityNotFoundException(
                    "Le fournisseur avec l ID "+ cfs.getFournisseur().getId() + "n existe pas dans la base de donnée",
                    ErrorCodes.FOURNISEUR_NOT_FOUND
            );
        }

        // verification si la ligne commande fournisseur est  est non vide ou
        List<String> erroArticle = new ArrayList<>();

        if (cfs.getLigneCommandeFourniseurDTOS() != null){
            cfs.getLigneCommandeFourniseurDTOS().forEach(lgcmf->{
                if(lgcmf.getArticleDTO() != null){
                    Optional<Article> article = articleRepository.findById(lgcmf.getArticleDTO().getId());
                    if (article.isEmpty()){
                        erroArticle.add("l article avec l ID "+ lgcmf.getArticleDTO().getId() +" n existe pas dans la base de donnée");
                    }
                }else {
                    erroArticle.add("impossible d'enregistre une commande avec un ID null");
                }
            });
        }
        //blockage
        if (!erroArticle.isEmpty()){
            log.warn("");
            throw new InvalidEntityException(
                    "l'article n'existe pas dans la base de donnée",
                    ErrorCodes.ARTICLE_NOT_FOUND, erroArticle
            );
        }

        // enregistrement de la commande fournisseur
        CommandeFournisseur saveComFournisseur = comFourRepository.save(CommandeFournisseurDTO.toEntity(cfs));
        if  (cfs.getLigneCommandeFourniseurDTOS() != null){
            // le bouclage de chaque ligne
            cfs.getLigneCommandeFourniseurDTOS().forEach(ligcmf->{
                //le mapping transformer l'objeet dto en entité
                LigneCommandeFourniseur ligneCommandeFourniseur = LigneCommandeFourniseurDTO.toEntity(ligcmf);
                // pour chaque ligne de commande client on a assigné la valeur
                ligneCommandeFourniseur.setCommandeFournisseur(saveComFournisseur);
                ligneComFourRepository.save(ligneCommandeFourniseur);
            });
        }
        return CommandeFournisseurDTO.fromEntity(saveComFournisseur);
    }

    @Override
    public CommandeFournisseurDTO findById(Integer id) {
        if (id == null){
            log.error("Commande fournisseur ID est null ");
            return  null;
        }
        return comFourRepository.findById(id)
                .map(CommandeFournisseurDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande fournisseur n a ete trouvé avec l ID "+id + "dans la base de donnée",
                        ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public CommandeFournisseurDTO findByCode(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Commande fournisseur code est null");
            return null;
        }
        return comFourRepository.findCommadeFourByCode(codeArticle)
                .map(CommandeFournisseurDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande fournisseur n a ete trouvé avec le code "+ codeArticle + "dans la base de donnée",
                        ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeFournisseurDTO> findAll() {
        return comFourRepository.findAll()
                .stream()
                .map(CommandeFournisseurDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("");
            return  ;
        }
        comFourRepository.deleteById(id);
    }
}
