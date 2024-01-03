package com.paulo.gestionstock0_1.service.implService;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;
import com.paulo.gestionstock0_1.entity.Article;
import com.paulo.gestionstock0_1.exception.EntityNotFoundException;
import com.paulo.gestionstock0_1.exception.ErrorCodes;
import com.paulo.gestionstock0_1.exception.InvalidEntityException;
import com.paulo.gestionstock0_1.repository.ArticleRepository;
import com.paulo.gestionstock0_1.service.ArticleService;
import com.paulo.gestionstock0_1.validation.ArticleValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisNoOpBindingRegistry;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
        List<String> errors = ArticleValidator.validate(articleDTO);
        if (!errors.isEmpty()){
            log.error("article is not valid {}", articleDTO);
            throw new InvalidEntityException("l'article n'est pas valide", ErrorCodes.ARTICLE_NOT_FOUND, errors);
        }
        return ArticleDTO.fromEntity(
                articleRepository.save(
                        ArticleDTO.toEntity(articleDTO)
                )
        );
    }


    @Override
    public ArticleDTO findById(Integer id) {
        if (id ==null){
            log.error("Article ID is null");
            return null;
        }

        // orElseThrow de l'objet Optional pour traiter le cas où l'article n'est pas trouvé et lancer une exception
        Optional<Article>  article = articleRepository.findById(id);

        return Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(()->
            new EntityNotFoundException(
                    "Aucun article avec l'ID = " + id + "n'a été trouvé dans la base de donnée",
                    ErrorCodes.ARTICLE_NOT_FOUND
            )
        );
    }



    @Override
    public ArticleDTO findByCode(String codeArticle) {
        //si la chaîne est nulle ou a une longueur de zéro, le bloc de code à l'intérieur de la condition sera exécuté.
        if (!StringUtils.hasLength(codeArticle)){
            log.error("Article CODE is null");
            return null;
        }

        Optional<Article>  article = articleRepository.findArticleByCodeArticle(codeArticle);

        return Optional.of(ArticleDTO.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException(
                        "Aucun article avec le CODE = " + codeArticle + "n'a été trouvé dans la base de donnée",
                        ErrorCodes.ARTICLE_NOT_FOUND
                )
        );
    }

    /**
     * La méthode stream() est utilisée pour transformer la liste d'articles en un flux, puis la méthode map est utilisée pour
     * appliquer la méthode statique fromEntity de la classe ArticleDTO à chaque élément du flux. Cela convertit chaque entité
     * d'article en un objet ArticleDTO
     * */
    @Override
    public List<ArticleDTO> findAll() {
        return articleRepository.findAll().stream()
                .map(ArticleDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null){
            log.error("Article ID is null");
            return ;
        }
        articleRepository.deleteById(id);

    }
}
