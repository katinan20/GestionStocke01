package com.paulo.gestionstock0_1.controller.api;

import com.paulo.gestionstock0_1.DTO.ArticleDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.paulo.gestionstock0_1.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/article")
public interface ArticleApi {
    @PostMapping(value = APP_ROOT+ "/article/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Enregistrer un article", notes = "Cette methode permet de modifier ou enregistrer un article", response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "L'objet article est creer ou modifier"),
            @ApiResponse(responseCode = "400", description = "L'objet article non creer ou modifier")
    })
    ArticleDTO save(@RequestBody ArticleDTO articleDTO);


    @GetMapping(value = APP_ROOT+ "/article/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes = "Cette methode permet de rechercher un article par son ID", response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "l'article à été trouver dans la base de donnée"),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la base de donnée avec l ID fourni")
    })
    ArticleDTO findById(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT+ "/article/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Rechercher un article", notes = "Cette methode permet de rechercher un article par son code", response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "l'article a été trouver dans la base de donnée"),
            @ApiResponse(responseCode = "404", description = "Aucun article n'existe dans la base de donnée avec le code fourni ")
    })
    ArticleDTO findByCode(@PathVariable("codeArticle") String codeArticle);


    @GetMapping(value = APP_ROOT+ "/article/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Renvoyer la liste d un article", notes = "Cette methode permet d afficher las liste des article", responseContainer = "List<ArticleDTO>")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "la liste des articles / une liste vide")
    })
    List<ArticleDTO> findAll();

    @DeleteMapping(value = APP_ROOT+ "/article/delete/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "supprimer un article", notes = "Cette methode permet de supprimer un article par son ID", response = ArticleDTO.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Article supprimer")
    })
    void delete(@PathVariable("idArticle") Integer id);

}
