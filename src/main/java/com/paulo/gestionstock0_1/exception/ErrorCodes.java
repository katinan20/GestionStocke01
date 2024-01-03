package com.paulo.gestionstock0_1.exception;
public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000),
    // TODO   complet the rest of the Error codes
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLIENT_NOT_FOUND(4000),
    COMMANDE_FOURNISSEUR_NOT_FOUND(5000),
    ENTREPRISE_NOT_FOUND(6000),
    FOURNISEUR_NOT_FOUND(7000),
    LIGNE_COMMANDE_CLIENT_NOT_FOUND(8000),
    LIGNE_COMMANDE_FOURNISEUR_NOT_FOUND(9000),
    LIGNE_VENTE_NOT_FOUND(10000),
    MVT_STK_NOT_FOUND(11000),
    ROLES_NOT_FOUND(12000),
    TYPE_MVT_STK_NOT_FOUND(13000),
    UTILISATEUR_NOT_FOUND(14000),
    VENTES_NOT_FOUND(15000) ;

    private int code;
    ErrorCodes(int code){
        this.code = code;
    }
    public int getCode(){
        return code;
    }
}
