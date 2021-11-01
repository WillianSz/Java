/**
 * Tem como função realizar a conexão com o banco de dados
 * */
package br.com.pizzaria.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoMySQL {

    private static final String USERNAME = "root"; // usuário padrão do mysql
    private static final String PASSWORD = "root"; // senha padrão do mysql
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pizzariarebot";

    public static Connection criarConexaoMySQL() throws Exception {
        //Faz a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");
        java.sql.Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        //Cria a conexao com o banco de dados
        return conexao;

    }
}
