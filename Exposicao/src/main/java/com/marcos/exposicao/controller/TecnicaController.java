/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.controller;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.model.Tecnica;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class TecnicaController {

    public boolean cadastrarTecnica(String descricao) throws ExceptionDAO {
        if (descricao != null && descricao.length() > 0) {

            Tecnica tecnica = new Tecnica(descricao);

            new Tecnica().cadastrarTecnica(tecnica);
        }
        return false;
    }
    
    public ArrayList<Tecnica> consultarTecnica() throws ExceptionDAO{
        ArrayList<Tecnica> tecnicas = new Tecnica().consultarTecnica();
        return tecnicas;
    }
    
    public void excluirTecnica(int idTecnica) throws ExceptionDAO{
        new Tecnica().excluirTecnica(idTecnica);
    }
}
