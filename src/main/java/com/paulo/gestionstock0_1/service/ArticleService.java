package com.paulo.gestionstock0_1.service;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;

import java.util.List;


public interface ArticleService {

    ArticleDTO save(ArticleDTO articleDTO);
    ArticleDTO findById(Integer id);
    ArticleDTO findByCode(String codeArticle);
    List<ArticleDTO> findAll();
    void delete(Integer id);

}
