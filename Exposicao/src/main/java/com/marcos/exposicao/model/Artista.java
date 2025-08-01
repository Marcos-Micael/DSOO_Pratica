/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.model;

import com.marcos.exposicao.dao.ArtistaDAO;
import com.marcos.exposicao.dao.ExceptionDAO;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class Artista {

    private String nome;
    private String nacionalidade;
    private int idArtistas;

    public Artista(int idArtistas) {
        this.idArtistas = idArtistas;
    }

    
    
    public Artista(String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public Artista(int idArtistas, String nome, String nacionalidade) {
        this.nome = nome;
        this.nacionalidade = nacionalidade;
        this.idArtistas = idArtistas;
    }

    public Artista() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getIdArtistas() {
        return idArtistas;
    }

    public void setIdArtistas(int idArtistas) {
        this.idArtistas = idArtistas;
    }

    public void cadastrarArtista(Artista artista) throws ExceptionDAO {
        new ArtistaDAO().cadastrarArtista(artista);
    }

    public void atualizarArtista(Artista artista) throws ExceptionDAO {
        new ArtistaDAO().atualizarArtista(artista);
    }

    public void excluirArtista(int idArtista) throws ExceptionDAO {
        new ArtistaDAO().excluirArtista(idArtista);
    }

    public ArrayList<Artista> consultarArtista() throws ExceptionDAO {
        ArrayList<Artista> artistas = new ArtistaDAO().consultarArtista();

        return artistas;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
