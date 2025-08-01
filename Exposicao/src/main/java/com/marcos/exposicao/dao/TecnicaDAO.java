/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.dao;

import com.marcos.exposicao.model.Tecnica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class TecnicaDAO {
    
    public void cadastrarTecnica(Tecnica tecnica) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            String strSQL = "insert into tecnica (descricao) " + " values (?);";
            connection = new ConexaoBanco().getConnection();
            
            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setString(1, tecnica.getDescricao());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao tentar cadastrar tecnica");
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
    
    public ArrayList<Tecnica> consultarTecnica() throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Tecnica> tecnicas = null;
        ResultSet resultSet = null;
        
        try {
            String strSQL = " Select id_tecnica, descricao from tecnica;";
            connection = new ConexaoBanco().getConnection();
            
            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                resultSet = preparedStatement.executeQuery();
                tecnicas = new ArrayList<>();
                
                while (resultSet.next()) {
                    int idTecnica = resultSet.getInt("id_tecnica");
                    String descricao = resultSet.getString("descricao");
                    Tecnica tecnica = new Tecnica(idTecnica, descricao);
                    tecnicas.add(tecnica);
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro na consulta:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
        return tecnicas;
    }
    
    public void excluirTecnica(int idTecnica) throws ExceptionDAO{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try{
            String strSQL = "delete from tecnica where id_tecnica = ?;";
            connection = new ConexaoBanco().getConnection();
            
            if(connection != null){
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setInt(1, idTecnica);
                preparedStatement.execute();
            }
        } catch(SQLException e){
            throw new ExceptionDAO("Erro ao excluir Tecnica:");
        } finally{
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
}
