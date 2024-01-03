package com.paulo.gestionstock0_1.controller;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;
import com.paulo.gestionstock0_1.controller.api.ArticleApi;
import com.paulo.gestionstock0_1.service.ArticleService;
import com.paulo.gestionstock0_1.service.implService.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticleApi {

    private ArticleServiceImpl articleService;

    @Autowired
    public ArticleController(ArticleServiceImpl articleService){
        this.articleService = articleService;
    }

    @Override
    public ArticleDTO save(ArticleDTO articleDTO) {
        return articleService.save(articleDTO);
    }

    @Override
    public ArticleDTO findById(Integer id) {
        return articleService.findById(id);
    }

    @Override
    public ArticleDTO findByCode(String codeArticle) {
        return articleService.findByCode(codeArticle);
    }

    @Override
    public List<ArticleDTO> findAll() {
        return articleService.findAll();
    }

    @Override
    public void delete(Integer id) {
        articleService.delete(id);
    }
}