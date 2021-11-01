package br.com.pizzaria.painel;

import br.com.pizzaria.dao.ClienteDAO;
import br.com.pizzaria.dao.FuncionariosDAO;
import javax.swing.JOptionPane;
import br.com.pizzaria.tabelas.Cliente;
import br.com.pizzaria.tabelas.Funcionarios;

public class PainelConsole {

    public static void main(String[] args) {

        loop:
        do {

            int request = Integer.parseInt(JOptionPane.showInputDialog("Escolha a tabela:\n 1 para Clientes \n 2 Para Funcionarios \n 0 parar encerrar o programa."));

            switch (request) {
                case 0:
                    System.out.println("Encerrando o sistema.");
                    break loop;
                case 1:
                    int funcoesc = Integer.parseInt(JOptionPane.showInputDialog(
                            "Tabela Clientes\nInforme a ação desejada:"
                            + "\n 1 Para Create(Salvar Clientes)"
                            + "\n 2 Para Read(Listar Clientes)"
                            + "\n 3 Para Update(Atualizar um Cliente)"
                            + "\n 4 Para Delete(Apagar um Cliente)"
                            + "\n"));
                    switch (funcoesc) {
                        case 1:
                            CriarCliente();
                            break;
                        case 2:
                            ListarClientes();
                            break;
                        case 3:
                            atualizarCliente();
                            break;
                        case 4:
                            ApagarCliente();
                            break;
                    }
                    break;
                case 2:
                    int funcoesf = Integer.parseInt(JOptionPane.showInputDialog(
                            "Tabela Funcionarios\nInforme a ação desejada:"
                            + "\n 1 Para Create(Salvar Funcionários)"
                            + "\n 2 Para Read(Listar Funcionários)"
                            + "\n 3 Para Update(Atualizar Funcionários)"
                            + "\n 4 Para Delete(Apagar Funcionários)"
                            + "\n"));
                    switch (funcoesf) {
                        case 1:
                            CriarFuncionario();
                            break;
                        case 2:
                            ListarFuncionario();
                            break;
                        case 3:
                            AtualizarFuncionario();
                            break;
                        case 4:
                            ApagarFuncionario();
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção Inválida");
            }

        } while (true);
    }
// Clientes 

    public static void CriarCliente() {
        ClienteDAO cld = new ClienteDAO();
        Cliente clt = new Cliente();

        clt.setNome(JOptionPane.showInputDialog("Informe o nome do cliente"));
        clt.setEndereco(JOptionPane.showInputDialog("Informe o endereço do cliente"));
        clt.setMetodoPagamento(JOptionPane.showInputDialog("Informe o Metodo de pagamento"));
        clt.setSaborPizza(JOptionPane.showInputDialog("Informe o Sabor da pizza"));
        clt.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone do cliente")));

        cld.CriarCliente(clt);
    }

    public static void ApagarCliente() {
        ClienteDAO cld = new ClienteDAO();
        int linha = cld.ApagarClientes(Integer.parseInt(JOptionPane.showInputDialog("Informe o id: ")));
        if (linha > 0) {
            System.out.println("Cliente apagado com sucesso!");
        } else {
            System.out.println("Cliente Não existe!");
        }

    }

    public static void atualizarCliente() {
        Cliente clt = new Cliente();
        ClienteDAO cld = new ClienteDAO();
        clt.setNome(JOptionPane.showInputDialog("Novo Nome"));
        clt.setEndereco(JOptionPane.showInputDialog("Novo Endereço"));
        clt.setMetodoPagamento(JOptionPane.showInputDialog("Novo Metodo de Pagamento"));
        clt.setSaborPizza(JOptionPane.showInputDialog("Novo Sabor"));
        clt.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Novo Telefone")));
        clt.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID")));
        cld.AtualizarClientes(clt);
    }

    public static void ListarClientes() {
        ClienteDAO cld = new ClienteDAO();
        System.out.println("Listando os Clientes:");
        for (Cliente cliente : cld.ListarClientes()) {
            System.out.println("Id: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("Endereço: " + cliente.getEndereco());
            System.out.println("MetodoPagamento: " + cliente.getMetodoPagamento());
            System.out.println("Sabores Pedidos: " + cliente.getSaborPizza());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("Fim da Listagem.");
    }
// Funcionários
    
    
    
    
//----------------------------------------------------------------------

    public static void CriarFuncionario(){
        FuncionariosDAO fnD = new FuncionariosDAO();
        Funcionarios fnc = new Funcionarios();
        fnc.setNome(JOptionPane.showInputDialog("Informe o nome do Funcionario"));
        fnc.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone do Funcionario")));
        fnc.setEndereco(JOptionPane.showInputDialog("Informe o endereço do Funcionario"));
        fnc.setCargo(JOptionPane.showInputDialog("Informe o Cargo"));
        fnD.CriarFuncionarios(fnc);
    }

    public static void ApagarFuncionario() {
        FuncionariosDAO fnD = new FuncionariosDAO();
        int linha = fnD.ApagarFuncionarios(Integer.parseInt(JOptionPane.showInputDialog("Informe o id: ")));
        if (linha > 0) {
            System.out.println("Funcionario apagado com sucesso!");
        } else {
            System.out.println("Funcionario Não existe!");
        }

    }

    public static void AtualizarFuncionario() {
        FuncionariosDAO fnD = new FuncionariosDAO();
        Funcionarios fnc = new Funcionarios();
        fnc.setNome(JOptionPane.showInputDialog("Novo Nome"));
        fnc.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Novo Telefone")));
        fnc.setEndereco(JOptionPane.showInputDialog("Novo Endereço"));
        fnc.setCargo(JOptionPane.showInputDialog("Novo Cargo"));
        fnc.setId(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID")));
        fnD.AtualizarFuncionarios(fnc);
    }

    public static void ListarFuncionario() {
        FuncionariosDAO fnD = new FuncionariosDAO();
        System.out.println("Listando os Funcionarios:");
        for (Funcionarios funcionario : fnD.ListarFuncionarios()) {
            System.out.println("Id: " + funcionario.getId());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Endereço: " + funcionario.getEndereco());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("-----------------------------------------------------------------------");
        }
        System.out.println("Fim da Listagem.");
    }
}
