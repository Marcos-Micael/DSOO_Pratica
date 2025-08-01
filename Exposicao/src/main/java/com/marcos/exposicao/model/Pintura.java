/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.model;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.dao.PinturaDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class Pintura {

    private String tipoTinta;
    private String titulo;
    private int idObra;
    private String dataAquisicao;
    private String dimensoes;
    private int idArtista;

    public Pintura(String tipoTinta, String titulo, int idObra, String dataAquisicao, String dimensoes, int idArtista) {
        this.tipoTinta = tipoTinta;
        this.titulo = titulo;
        this.idObra = idObra;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
        this.idArtista = idArtista;
    }

    public Pintura(String tipoTinta, String titulo, int idObra, String dataAquisicao, String dimensoes) {
        this.tipoTinta = tipoTinta;
        this.titulo = titulo;
        this.idObra = idObra;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
    }

    public Pintura(String titulo, String dimensoes, String dataAquisicao, String tipoTinta, int idArtista) {
        this.tipoTinta = tipoTinta;
        this.titulo = titulo;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
        this.idArtista = idArtista;
    }

    public Pintura() {
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }

    public String getTipoTinta() {
        return tipoTinta;
    }

    public void setTipoTinta(String tipoTinta) {
        this.tipoTinta = tipoTinta;
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

    public String getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(String dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public void cadastrarPintura(Pintura pintura) throws ExceptionDAO {
        new PinturaDAO().cadastrarPintura(pintura);
    }

    public void atualizarPintura(Pintura pintura) throws ExceptionDAO {
        new PinturaDAO().atualizarPintura(pintura);
    }

    public void excluirPintura(int idPintura) throws ExceptionDAO {
        new PinturaDAO().excluirPintura(idPintura);
    }

    public ArrayList<Pintura> consultarPintura() throws ExceptionDAO {
        ArrayList<Pintura> pinturas = new PinturaDAO().consultarPintura();

        return pinturas;
    }

}
