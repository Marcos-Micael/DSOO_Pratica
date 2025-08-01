/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.controller;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.model.Artista;
import com.marcos.exposicao.model.Pintura;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class PinturaController {

    public boolean cadastrarPintura(String titulo, String dimensoes, String dataAquisicao, String tipoTinta, int idArtista) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0 && dimensoes != null && dimensoes.length() > 0 && dataAquisicao != null && dataAquisicao.length() > 0
                && tipoTinta != null && tipoTinta.length() > 0 && idArtista != -1) {

            Pintura pintura = new Pintura(titulo, dimensoes, dataAquisicao, tipoTinta, idArtista);

            new Pintura().cadastrarPintura(pintura);

            return true;
        }
        return false;
    }

    public ArrayList<Pintura> consultarPintura() throws ExceptionDAO {
        ArrayList<Pintura> pinturas = new Pintura().consultarPintura();
        return pinturas;
    }

    public void excluirPintura(int idPintura) throws ExceptionDAO {
        new Pintura().excluirPintura(idPintura);
    }

    public boolean atualizarPintura(int idObra, String titulo, String dimensoes, String dataAquisicao, String tipoTinta) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0 && dimensoes != null && dimensoes.length() > 0 && dataAquisicao != null && dataAquisicao.length() > 0
                && tipoTinta != null && tipoTinta.length() > 0) {
            
            Pintura pintura = new Pintura(tipoTinta, titulo, idObra, dataAquisicao, dimensoes);
            
            new Pintura().atualizarPintura(pintura);
            return true;
        }
        return false;
    }
}
