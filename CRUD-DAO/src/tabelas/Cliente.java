package br.com.pizzaria.tabelas;

public class Cliente {

    private String nome;
    private String endereco;
    private String MetodoPagamento;
    private String SaborPizza;
    private int telefone;
    private int id;

    public String getMetodoPagamento() {
        return MetodoPagamento;
    }

    public void setMetodoPagamento(String MetodoPagamento) {
        this.MetodoPagamento = MetodoPagamento;
    }

    public String getSaborPizza() {
        return SaborPizza;
    }

    public void setSaborPizza(String SaborPizza) {
        this.SaborPizza = SaborPizza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
