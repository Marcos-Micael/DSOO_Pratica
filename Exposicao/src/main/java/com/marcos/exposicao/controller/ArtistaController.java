/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.controller;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.model.Artista;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class ArtistaController {

    public boolean cadastrarArtista(String nome, String nacionalidade) throws ExceptionDAO {
        if (nome != null && nome.length() > 0 && nacionalidade != null && nacionalidade.length() > 0) {

            Artista artista = new Artista(nome, nacionalidade);

            new Artista().cadastrarArtista(artista);

            return true;
        }
        return false;
    }

    public ArrayList<Artista> consultarArtista() throws ExceptionDAO {
        ArrayList<Artista> artistas = new Artista().consultarArtista();
        return artistas;
    }
    
    public void excluirArtista(int idArtista) throws ExceptionDAO{
        new Artista().excluirArtista(idArtista);
    }
    
    public boolean atulaizarArtista(int idArtista, String nome, String nacionalidade) throws ExceptionDAO{
        if(nome != null && nome.length() > 0 && nacionalidade != null && nacionalidade.length() > 0){
            Artista artista = new Artista(idArtista, nome, nacionalidade);
            
            new Artista().atualizarArtista(artista);
            return true;
        }
        
        return false;
    }

}
