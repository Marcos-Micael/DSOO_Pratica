/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.dao;

import com.marcos.exposicao.model.Pintura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class PinturaDAO {

    public void cadastrarPintura(Pintura pintura) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "insert into obra (titulo, dimensoes, data_aquisicao, tipo_Tinta, idArtista)" + " values (?,?,?,?,?);";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setString(1, pintura.getTitulo());
                preparedStatement.setString(2, pintura.getDimensoes());
                preparedStatement.setString(3, pintura.getDataAquisicao());
                preparedStatement.setString(4, pintura.getTipoTinta());
                preparedStatement.setInt(5, pintura.getIdArtista());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao tentar cadastrar pintura:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }

    public ArrayList<Pintura> consultarPintura() throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Pintura> pinturas = null;
        ResultSet resultSet = null;

        try {
            String strSQL = "Select idObra, idArtista, titulo, data_aquisicao, dimensoes, tipo_Tinta from obra where material is null;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                resultSet = preparedStatement.executeQuery();
                pinturas = new ArrayList<>();

                while (resultSet.next()) {
                    int idObra = resultSet.getInt("idObra");
                    int idArtista = resultSet.getInt("idArtista");
                    String titulo = resultSet.getString("titulo");
                    String data = resultSet.getString("data_aquisicao");
                    String dimensoes = resultSet.getString("dimensoes");
                    String tipoTinta = resultSet.getString("tipo_Tinta");
                    Pintura pintura = new Pintura(tipoTinta, titulo, idObra, data, dimensoes, idArtista);
                    pinturas.add(pintura);
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro na consulta: " + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
        return pinturas;
    }

    public void excluirPintura(int idPintura) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "delete from obra where idObra = ?;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setInt(1, idPintura);
                preparedStatement.execute();
            }
        } catch(SQLException e)  {
            throw new ExceptionDAO("Erro ao exclui Pintura" + e);
        } finally{
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
    
    public void atualizarPintura(Pintura pintura) throws ExceptionDAO{
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{
            String strSQL = "update obra set ";
            strSQL += " titulo = ?, data_aquisicao = ?, dimensoes = ?, tipo_Tinta = ? ";
            strSQL += " where idObra = ?;";
            
            connection = new ConexaoBanco().getConnection();
            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setString(1, pintura.getTitulo());
            preparedStatement.setString(2, pintura.getDataAquisicao());
            preparedStatement.setString(3, pintura.getDimensoes());
            preparedStatement.setString(4, pintura.getTipoTinta());
            preparedStatement.setInt(5, pintura.getIdObra());
            preparedStatement.execute();
        } catch(SQLException e){
            throw new ExceptionDAO("Erro ao atualizar Pintura: " + e);
        } finally{
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
}
