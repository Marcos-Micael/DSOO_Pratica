/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.model;

import com.marcos.exposicao.dao.ArtistaDAO;
import com.marcos.exposicao.dao.EsculturaDAO;
import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.dao.PinturaDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class Escultura {

    private String titulo;
    private int idObra;
    private int idArtista;
    private String dataAquisicao;
    private String dimensoes;
    private String material;

    public Escultura(String titulo, int idObra, int idArtista, String dataAquisicao, String dimensoes, String material) {
        this.titulo = titulo;
        this.idObra = idObra;
        this.idArtista = idArtista;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
        this.material = material;
    }

    public Escultura(String titulo, int idObra, String dataAquisicao, String dimensoes, String material) {
        this.titulo = titulo;
        this.idObra = idObra;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
        this.material = material;
    }

    public Escultura(String titulo, String dataAquisicao, String dimensoes, String material, int idArtista) {
        this.titulo = titulo;
        this.dataAquisicao = dataAquisicao;
        this.dimensoes = dimensoes;
        this.material = material;
        this.idArtista = idArtista;
    }
    
    

    public Escultura() {
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

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    
    
    public void cadastrarEscultura(Escultura escultura) throws ExceptionDAO {
        new EsculturaDAO().cadastrarEscultura(escultura);
    }

    public void atualizarEscultura(Escultura escultura) throws ExceptionDAO {
        new EsculturaDAO().atualizarPintura(escultura);
    }

    public void excluirEscultura(int idObra) throws ExceptionDAO {
        new EsculturaDAO().excluirPintura(idObra);
    }

    public ArrayList<Escultura> listarEscultura() throws ExceptionDAO {
        ArrayList<Escultura> esculturas = new EsculturaDAO().consultarEscultura();

        return esculturas;
    }

}
