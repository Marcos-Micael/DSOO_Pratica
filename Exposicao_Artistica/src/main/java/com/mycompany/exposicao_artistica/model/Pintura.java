/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposicao_artistica.model;

import java.sql.Date;

/**
 *
 * @author marco
 */
public class Pintura extends Obra{ 
    private String tipoTinta;

    public Pintura(String tipoTinta, String titulo, Date dataAquisicao, String dimensoes) {
        super(titulo, dataAquisicao, dimensoes);
        this.tipoTinta = tipoTinta;
    }

    public Pintura(String tipoTinta, String titulo, int idObra, Date dataAquisicao, String dimensoes) {
        super(titulo, idObra, dataAquisicao, dimensoes);
        this.tipoTinta = tipoTinta;
    }

    public String getTipoTinta() {
        return tipoTinta;
    }

    public void setTipoTinta(String tipoTinta) {
        this.tipoTinta = tipoTinta;
    }
    
    
}
