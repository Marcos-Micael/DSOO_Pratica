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
public class Escultura extends Obra{
    
    private String material;

    public Escultura(String material, String titulo, Date dataAquisicao, String dimensoes) {
        super(titulo, dataAquisicao, dimensoes);
        this.material = material;
    }

    public Escultura(String material, String titulo, int idObra, Date dataAquisicao, String dimensoes) {
        super(titulo, idObra, dataAquisicao, dimensoes);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    
    
}
