package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.CommandeClientDTO;
import com.paulo.gestionstock0_1.DTO.LigneCommandeClientDTO;
import com.paulo.gestionstock0_1.entity.Article;
import com.paulo.gestionstock0_1.entity.Client;
import com.paulo.gestionstock0_1.entity.CommandeClient;
import com.paulo.gestionstock0_1.entity.LigneCommandeClient;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.ArticleRepository;
import com.paulo.gestionstock0_1.repository.ClientRepository;
import com.paulo.gestionstock0_1.repository.ComClientRepository;
import com.paulo.gestionstock0_1.repository.LigneComClientRepository;
import com.paulo.gestionstock0_1.service.CommandClientService;
import com.paulo.gestionstock0_1.validation.CommandeClientValidator;
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
public class CommandeClientServiceImp implements CommandClientService {
    private ComClientRepository comClientRepository;
    private ArticleRepository articleRepository;
    private ClientRepository clientRepository;
    private LigneComClientRepository ligneComClientRepository;
    @Autowired
    public CommandeClientServiceImp(ComClientRepository comClientRepository,
                                    ArticleRepository articleRepository,
                                    ClientRepository clientRepository,
                                    LigneComClientRepository ligneComClientRepository)

    {
        this.comClientRepository = comClientRepository;
        this.articleRepository = articleRepository;
        this.clientRepository = clientRepository;
        this.ligneComClientRepository = ligneComClientRepository;
    }

    @Override
    public CommandeClientDTO save(CommandeClientDTO cocl) {

        // verification si le client a remplit les champs
        List<String> errors = CommandeClientValidator.validate(cocl);
        if (!errors.isEmpty()){
            log.error("Commande Client n'est pas valide");
            throw new InvalidEntityException("la commande client n'est pas valide",
                    ErrorCodes.COMMANDE_CLIENT_NOT_FOUND, errors);
        }

        /* verifier si le client est dans la base de donnée **/
        Optional<Client> client = clientRepository.findById(cocl.getClient().getId());
        if (client.isEmpty()){
            log.error("le client avec ID {} n est dans la base de donné", cocl.getClient().getId());
            throw new EntityNotFoundException("Aucun client avec l'ID"+cocl.getClient().getId()+"n est dans la base de donnée",
                    ErrorCodes.CLIENT_NOT_FOUND);
        }

        // verification si la ligne commande client est non vide ou
        List<String> articleErrors = new ArrayList<>();

        if (cocl.getLigneCommandeClients() != null){
            cocl.getLigneCommandeClients().forEach(ligCmdCl ->{
                if (ligCmdCl.getArticleDTO() != null){ // voir si l article est non vide
                    Optional<Article> article = articleRepository.findById(ligCmdCl.getArticleDTO().getId());
                    if (article.isEmpty()){ //voir si l article est non vide ou existe dans la base de donnée
                        articleErrors.add("l'article avec l ID "+ ligCmdCl.getArticleDTO().getId() + "n'existe pas dans la base de donnée");
                    }
                }else {
                    articleErrors.add("impossible d'enregistrer une commande avec un article null");
                }
            });
        }
        //blocker
        if (!articleErrors.isEmpty()){
            log.warn("");
            throw new InvalidEntityException("l'article n'existe pas dans la base de donnée", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
        }
        // enregistrement de la commande client
        CommandeClient saveComClient = comClientRepository.save(CommandeClientDTO.toEntity(cocl));
        if (cocl.getLigneCommandeClients() != null){
            // le bouclage de chaque ligne
            cocl.getLigneCommandeClients().forEach( ligCmdClt ->{
                //le mapping transformer l'objeet dto en entité
                LigneCommandeClient ligneCommandeClient = LigneCommandeClientDTO.toEntity(ligCmdClt);
                // pour chaque ligne de commande client on a assigné la valeur
                ligneCommandeClient.setCommandeClient(saveComClient);
                ligneComClientRepository.save(ligneCommandeClient);
            });
        }
        return CommandeClientDTO.fromEntity(saveComClient);
    }

    @Override
    public CommandeClientDTO findById(Integer id) {
        if (id == null){
            log.error("l'ID de la commande est null");
            return null;
        }
        return comClientRepository.findById(id)
                .map(CommandeClientDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande client n'a été trouové avec l ID " + id + "dans la base de donnée",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public CommandeClientDTO findByCode(String codeArticle) {
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Commande Client code est null");
            return null;
        }
        return comClientRepository.findCommandeClientByCode(codeArticle)
                .map(CommandeClientDTO::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException(
                        "Aucune commande client na ete trouvé avec le code " + codeArticle + "dans la base de donnée",
                        ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
                ));
    }

    @Override
    public List<CommandeClientDTO> findAll() {
        return comClientRepository.findAll()
                .stream()
                .map(CommandeClientDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Commande client ID null");
            return;
        }
        comClientRepository.deleteById(id);
    }
}
