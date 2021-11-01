package br.com.pizzaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.pizzaria.conexao.ConexaoMySQL;
import br.com.pizzaria.tabelas.Funcionarios;

public class FuncionariosDAO {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rst = null;

    public void CriarFuncionarios(Funcionarios Funcionario) {

        String sql = "INSERT INTO Funcionarios (Nome,Telefone,Endereco,Cargo) VALUES (?,?,?,?);";

        try {
            conn = ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, Funcionario.getNome());
            pstm.setInt(2, Funcionario.getTelefone());
            pstm.setString(3, Funcionario.getEndereco());
            pstm.setString(4, Funcionario.getCargo());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void AtualizarFuncionarios(Funcionarios Funcionario) {

        String sql = "UPDATE Funcionarios SET Nome=(?),Telefone=(?),Endereco=(?),Cargo=(?) where Id=(?);";

        try {
            conn = ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, Funcionario.getNome());
            pstm.setInt(2, Funcionario.getTelefone());
            pstm.setString(3, Funcionario.getEndereco());
            pstm.setString(4, Funcionario.getCargo());
            pstm.setInt(5, Funcionario.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public int ApagarFuncionarios(int id) {
        String sql = "DELETE FROM Funcionarios WHERE Id=(?);";
        int linha = 0;
        try {
            conn = ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setInt(1, id);
            linha = pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Apagado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return linha;
    }

    public List<Funcionarios> ListarFuncionarios() {

        String sql = "SELECT * FROM Funcionarios;";
        List<Funcionarios> Funcionario = new ArrayList<Funcionarios>();

        try {
            conn = br.com.pizzaria.conexao.ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rst = pstm.executeQuery(sql);

            while (rst.next()) {
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setId(rst.getInt("Id"));
                funcionarios.setNome(rst.getString("Nome"));
                funcionarios.setEndereco(rst.getString("Endereco"));
                funcionarios.setTelefone(rst.getInt("Telefone"));
                funcionarios.setCargo(rst.getString("Cargo"));

                Funcionario.add(funcionarios);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fecharConexao();
        }
        return Funcionario;
    }

    private void fecharConexao() {
        try {
            if (rst != null) {
                rst.close();
            }
            if (pstm != null) {
                pstm.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
