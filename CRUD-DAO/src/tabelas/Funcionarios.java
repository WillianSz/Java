package br.com.pizzaria.tabelas;

public class Funcionarios {

    private String nome;
    private String endereco;
    private int telefone;
    private String Cargo;
    private int id;

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
