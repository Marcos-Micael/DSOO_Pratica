/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.marcos.exposicao.dao;

import com.marcos.exposicao.model.Artista;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 202312030002
 */
public class ArtistaDAO {

    public void cadastrarArtista(Artista artista) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "insert into artista (nome, nacionalidade)" + " value (?, ?);";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setString(1, artista.getNome());
                preparedStatement.setString(2, artista.getNacionalidade());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao tentar cadastrar artista:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }

    public ArrayList<Artista> consultarArtista() throws ExceptionDAO {
        ArrayList<Artista> artistas = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String strSQL = "select * from artista;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                resultSet = preparedStatement.executeQuery();
                artistas = new ArrayList<>();

                while (resultSet.next()) {
                    int idArtista = resultSet.getInt("idartista");
                    String nomeArtista = resultSet.getString("nome");
                    String nacionalidade = resultSet.getString("nacionalidade");
                    Artista artistaAtual = new Artista(idArtista, nomeArtista, nacionalidade);
                    artistas.add(artistaAtual);
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro na consulta: " + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
        return artistas;
    }

    public void excluirArtista(int idArtista) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "delete from artista where idartista = ?;";
            connection = new ConexaoBanco().getConnection();

            if (connection != null) {
                preparedStatement = connection.prepareStatement(strSQL);
                preparedStatement.setInt(1, idArtista);
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao excluir artista:" + e);
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }

    public void atualizarArtista(Artista artista) throws ExceptionDAO {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            String strSQL = "update artista set ";
            strSQL += " nome = ?, nacionalidade = ? ";
            strSQL += " where idartista = ?;";

            connection = new ConexaoBanco().getConnection();
            preparedStatement = connection.prepareStatement(strSQL);
            preparedStatement.setString(1, artista.getNome());
            preparedStatement.setString(2, artista.getNacionalidade());
            preparedStatement.setInt(3, artista.getIdArtistas());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao atulizar Artista");
        } finally {
            ConexaoBanco.fecharPreparedStatement(preparedStatement);
            ConexaoBanco.fecharConexao(connection);
        }
    }
}
