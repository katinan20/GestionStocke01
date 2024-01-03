package com.paulo.gestionstock0_1.repository;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;
import com.paulo.gestionstock0_1.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Optional<Article> findArticleByCodeArticle(String codeArticle);

  /*  @Query("select a from Article a where a.entreprise.id=:x order by a.creationDate desc")
    List<ArticleDTO> listeOperation(@Param("x") ArticleDTO codec);
*/
}
