/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exposicao_artistica.model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public abstract class Obra {

    private String titulo;
    private int idObra;
    private Date dataAquisicao;
    private String dimensoes;

    public Obra(String titulo, Date dataAquisicao, String dimensoes) {
        this.titulo = titulo;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
    }

    public Obra(String titulo, int idObra, Date dataAquisicao, String dimensoes) {
        this.titulo = titulo;
        this.idObra = idObra;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdObra() {
        return idObra;
    }

    public void setIdObra(int idObra) {
        this.idObra = idObra;
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public void cadastrarObra() {

    }

    public void atualizarObra() {

    }

    public void excluirObra() {

    }

    public ArrayList<Obra> consultarObra() {
        return null;
    }

}
