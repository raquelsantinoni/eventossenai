package com.eventos.enums;

public enum Perfil {
    ADMINISTRADOR("Administrador", "Adm"),
    GERENTE("Gerente", "Ger"),
    USUARIO("Usuario", "Usr");

    private final String descricao;
    private final String sigla;

    Perfil(String descricao, String sigla){
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao(){
        return descricao;
    }

    public String getSigla(){
        return sigla;
    }

}
