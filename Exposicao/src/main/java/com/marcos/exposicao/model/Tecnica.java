/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.model;

import com.marcos.exposicao.dao.ExceptionDAO;
import com.marcos.exposicao.dao.TecnicaDAO;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class Tecnica {

    private int idTecnica;
    private String descricao;

    public Tecnica(int idTecnica, String descricao) {
        this.idTecnica = idTecnica;
        this.descricao = descricao;
    }

    public Tecnica(String descricao) {
        this.descricao = descricao;
    }

    public Tecnica() {
    }

    public int getIdTecnica() {
        return idTecnica;
    }

    public void setIdTecnica(int idTecnica) {
        this.idTecnica = idTecnica;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void cadastrarTecnica(Tecnica tecnica) throws ExceptionDAO {
        new TecnicaDAO().cadastrarTecnica(tecnica);
    }
    
    public ArrayList<Tecnica> consultarTecnica() throws ExceptionDAO{
        ArrayList<Tecnica> tecnicas = new TecnicaDAO().consultarTecnica();
        return tecnicas;
    }
    
    public void excluirTecnica(int idTecnica) throws ExceptionDAO{
        new TecnicaDAO().excluirTecnica(idTecnica);
    }
    
    public String toString(){
        return descricao;
    } 

}
