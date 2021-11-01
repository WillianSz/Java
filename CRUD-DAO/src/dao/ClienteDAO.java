package br.com.pizzaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import br.com.pizzaria.conexao.ConexaoMySQL;
import br.com.pizzaria.tabelas.Cliente;

public class ClienteDAO {

    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rst = null;

    public void CriarCliente(Cliente cliente) {

        String insert = "INSERT INTO Clientes(Nome,Endereco,MetodoPagamento,SaborPizza,Telefone) VALUES(?,?,?,?,?);";
        try {
            conn = ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(insert);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getMetodoPagamento());
            pstm.setString(4, cliente.getSaborPizza());
            pstm.setInt(5, cliente.getTelefone());
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Criado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public void AtualizarClientes(Cliente cliente) {

        String sql = "UPDATE Clientes SET Nome=(?),Endereco=(?),MetodoPagamento=(?),SaborPizza=(?),Telefone=(?) where Id=(?);";


        try {

            conn = ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getEndereco());
            pstm.setString(3, cliente.getMetodoPagamento());
            pstm.setString(4, cliente.getSaborPizza());
            pstm.setInt(5, cliente.getTelefone());
            pstm.setInt(6, cliente.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public int ApagarClientes(int id) {
        String sql = "DELETE FROM Clientes WHERE Id = ?";
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

    public List<Cliente> ListarClientes() {

        String select = "SELECT * FROM Clientes";

        List<Cliente> clientes = new ArrayList<Cliente>();

        try {

            conn = br.com.pizzaria.conexao.ConexaoMySQL.criarConexaoMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(select);
            rst = pstm.executeQuery(select);

            while (rst.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(rst.getInt("Id"));
                cliente.setNome(rst.getString("Nome"));
                cliente.setEndereco(rst.getString("Endereco"));
                cliente.setMetodoPagamento(rst.getString("MetodoPagamento"));
                cliente.setSaborPizza(rst.getString("SaborPizza"));
                cliente.setTelefone(rst.getInt("Telefone"));

                clientes.add(cliente);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            fecharConexao();
        }
        return clientes;
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
