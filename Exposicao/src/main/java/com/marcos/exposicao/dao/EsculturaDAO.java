/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.dao;

import com.marcos.exposicao.model.Escultura;
import com.marcos.exposicao.model.Pintura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class EsculturaDAO {

    public void cadastrarEscultura(Escultura escultura) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "insert into obra (titulo, dimensoes, data_aquisicao, material, idArtista)" + " values (?,?,?,?,?);";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {

                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setString(1, escultura.getTitulo());
                preparedStatement.setString(2, escultura.getDimensoes());
                preparedStatement.setString(3, escultura.getDataAquisicao());
                preparedStatement.setString(4, escultura.getMaterial());
                preparedStatement.setInt(5, escultura.getIdArtista());
                preparedStatement.execute();

            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao tentar cadastrar pintura:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }

    public ArrayList<Escultura> consultarEscultura() throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ArrayList<Escultura> esculturas = null;
        ResultSet resultSet = null;

        try {

            String strSQL = "Select idObra, idArtista, titulo, data_aquisicao, dimensoes, material from obra where tipo_tinta is null;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                resultSet = preparedStatement.executeQuery();
                esculturas = new ArrayList<>();

                while (resultSet.next()) {
                    int idObra = resultSet.getInt("idObra");
                    int idArtista = resultSet.getInt("idArtista");
                    String titulo = resultSet.getString("titulo");
                    String data = resultSet.getString("data_aquisicao");
                    String dimensoes = resultSet.getString("dimensoes");
                    String material = resultSet.getString("material");
                    Escultura escultura = new Escultura(titulo, idObra, idArtista, data, dimensoes, material);
                    esculturas.add(escultura);
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("Erro na consulta:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
        return esculturas;
    }

    public void excluirPintura(int idEscultura) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "delete from obra where idObra = ?;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setInt(1, idEscultura);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao exclui Escultura" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }

    public void atualizarPintura(Escultura escultura) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "update obra set ";
            strSQL += " titulo = ?, data_aquisicao = ?, dimensoes = ?, material = ? ";
            strSQL += " where idObra = ?;";

            connection = new ConexaoBanco().getConnection();
            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setString(1, escultura.getTitulo());
            preparedStatement.setString(2, escultura.getDataAquisicao());
            preparedStatement.setString(3, escultura.getDimensoes());
            preparedStatement.setString(4, escultura.getMaterial());
            preparedStatement.setInt(5, escultura.getIdObra());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao atualizar Pintura: " + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
    
    
}
