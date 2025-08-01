/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.controller;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.model.Escultura;
import com.marcos.exposicao.model.Pintura;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class EsculturaController {

    public boolean cadastrarEscultura(String titulo, String dimensoes, String dataAquisicao, String material, int idArtista) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0 && dimensoes != null && dimensoes.length() > 0 && dataAquisicao != null && dataAquisicao.length() > 0
                && material != null && material.length() > 0 && idArtista != -1) {

            Escultura escultura = new Escultura(titulo, dataAquisicao, dimensoes, material, idArtista);

            new Escultura().cadastrarEscultura(escultura);

            return true;
        }
        return false;
    }

    public ArrayList<Escultura> consultarEsculturas() throws ExceptionDAO {
        ArrayList<Escultura> esculturas = new Escultura().listarEscultura();
        return esculturas;
    }

    public void excluirEscultura(int idPintura) throws ExceptionDAO {
        new Escultura().excluirEscultura(idPintura);
    }

    public boolean atualizarPintura(int idObra, String titulo, String dimensoes, String dataAquisicao, String tipoTinta) throws ExceptionDAO {
        if (titulo != null && titulo.length() > 0 && dimensoes != null && dimensoes.length() > 0 && dataAquisicao != null && dataAquisicao.length() > 0
                && tipoTinta != null && tipoTinta.length() > 0) {

            Escultura escultura = new Escultura(titulo, idObra, dataAquisicao, dimensoes, titulo);

            new Escultura().atualizarEscultura(escultura);
            return true;
        }
        return false;
    }

}
