
import java.util.ArrayList;

public class Principal {
    public static String opcaoMenu;
    public static Locadora locadora = new Locadora();
        
    public static void main(String[] args) {        
        // Repete exibição de menu caso o usuário solicite
        do {
            Saida.menu();
            opcaoMenu = Entrada.recebeString();
            Saida.limparConsole();

            switch (opcaoMenu) {
                case "1": { // Registrar Filme
                    fluxoRegistrarFilme();
                    break;
                }
                case "2": {// Listar Filmes
                    Saida.cabecalhoFuncionalidade("Listar Filmes");
                    locadora.listarFilmes(null);
                    Saida.exibirBotoesDeAcao();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "3": { // Listar Filmes Atrasados
                    Saida.cabecalhoFuncionalidade("Listar Filmes Atrasados");
                    locadora.listarContratosAluguel(locadora.buscarAlugueisAtrasados());
                    Saida.exibirBotoesDeAcao();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "4": { // Alugar Filme
                    Saida.cabecalhoFuncionalidade("Alugar Filme");
                    fluxoCriarContrato(true);
                    break;
                }
                case "5": { // Registrar Devolução
                    Saida.cabecalhoFuncionalidade("Registrar Devolução");
                    fluxoRegistrarDevolucao();
                    Saida.exibirBotoesDeAcao();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "6": { // Vender Filme
                    Saida.cabecalhoFuncionalidade("Vender Filme");
                    fluxoCriarContrato(false);
                    break;
                }
                case "7": {// Listar Contratos Aluguel
                    Saida.cabecalhoFuncionalidade("Listar Contratos Aluguel");
                    locadora.listarContratosAluguel(locadora.contratosAluguel);
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "8": {// Listar Contratos Venda
                    Saida.cabecalhoFuncionalidade("Listar Contratos de Venda");
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "9": {// Listar Clientes
                    Saida.cabecalhoFuncionalidade("Listar Clientes");
                    locadora.listarClientes(false);
                    Saida.exibirBotoesDeAcao();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "10": { // Registrar Cliente
                    fluxoRegistrarCliente();
                    Saida.resultadoFuncao("Cadastro realizado com sucesso!");
                    opcaoMenu = Entrada.recebeString();
                    break;

                }
            }

            Saida.limparConsole();
        } while (!opcaoMenu.equals("0"));

        System.exit(0);
    }
    
    public static void fluxoRegistrarDevolucao() {
        locadora.listarContratosAluguel(locadora.buscarAlugueisVigentes());
        boolean contratoInvalido = true;

        do {      
            Saida.campoDeEntrada("Informe o código contrato");
            int codContrato = Entrada.recebeInt();
            int contratosSize = locadora.contratosAluguel.size();
            locadora.registrarDevolucaoFilme(codContrato);

            if (contratosSize >= 0 && (contratosSize - 1) >= codContrato) {
                contratoInvalido = false;
            } else {                    
                Saida.exibirErro("Código inválido");
            }                       
        } while(contratoInvalido);
        
        Saida.resultadoFuncao("Devolução realizado com sucesso!");
    }
      
    public static void fluxoCriarContrato(boolean ehContratoAluguel) {
        Saida.campoDeEntrada("Informe o nome do filme que deseja (Se nada for preenchido, a lista total será exibida)");
        String nomeFilmeDesejado = Entrada.recebeString();
        ArrayList<Filme> filmes = locadora.buscarFilme(nomeFilmeDesejado);

        if (!filmes.isEmpty()) {
            locadora.listarFilmes(filmes);
            boolean filmeInvalido = true;    
            int idFilme = -1;
            
            do {      
                Saida.campoDeEntrada("Informe o código do filme");  
                idFilme = Entrada.recebeInt();
                
                if (idFilme >= 0 && (filmes.size() - 1) >= idFilme) {
                    filmeInvalido = false;
                } else {                    
                    Saida.exibirErro("Código inválido");
                }                       
            } while(filmeInvalido);
            
            Filme filme = filmes.get(idFilme);
            filme.exibirDetalhesFilme();

            if (filme.getAlugado()) {
                Saida.resultadoFuncao("Este filme já está alugado :/");
                opcaoMenu = Entrada.recebeString();

            } else {
                String pergunta = ehContratoAluguel ? "Deseja alugar" : "Deseja vender";
                Saida.campoDeEntrada(pergunta + "?    | Sim (Enter) |     | Não (0) |");
                String alugarFilme = Entrada.recebeString();

                if (!alugarFilme.equals("0")) {
                    Cliente cliente = fluxoBuscarClienteParaContrato();
                    if (ehContratoAluguel) {
                        fluxoAlugarFilme(idFilme, filme, cliente);
                    } else {
                        fluxoVenderFilme(idFilme, filme, cliente);
                    }
                    Saida.resultadoFuncao("Execução realizada com sucesso!");
                    opcaoMenu = Entrada.recebeString();
                }
            }
        } else {
            Saida.resultadoFuncao("Infelizmente, não encontramos o filme :(");
            opcaoMenu = Entrada.recebeString();
        }
    }
    
    public static Cliente fluxoBuscarClienteParaContrato() {
        Cliente cliente = null;
        boolean clienteInvalido = true;
        locadora.listarClientes(true);

        do {
            Saida.campoDeEntrada("Informe o código do cliente ou digite 0 para cadastrar um novo");
            int clienteSelecionado = Entrada.recebeInt();
        
            if (clienteSelecionado == 0) {
                cliente = fluxoRegistrarCliente();
                clienteInvalido = false;
            } else {
                int codCliente = clienteSelecionado - 1;

                if (codCliente >= 0 && (locadora.clientes.size() - 1) >= codCliente) {
                    cliente = locadora.clientes.get(codCliente);
                    clienteInvalido = false;                                
                } else {
                    Saida.exibirErro("Código inválido");
                }
            }                        
        } while(clienteInvalido);
        
        return cliente;
    }
    
    public static void fluxoAlugarFilme(int idFilme, Filme filme, Cliente cliente) {
        boolean dataInvalida = true;
        ContratoAluguel contrato = new ContratoAluguel(filme, cliente);
        System.out.println("\n  |  Preencha o formulário de Aluguel  |");

        do {
            Saida.campoDeEntrada("Data de Devolução (Ex: dd/mm/aaaa)");
            String dataDevolucao = Entrada.recebeString();
            int erro = contrato.setDataDevolucao(dataDevolucao);

            if (erro != 0) {
                Saida.exibirErro(contrato.mensagemErroValidacaoDataDevolucao(erro));
            } else {
                dataInvalida = false;
            }
        } while(dataInvalida);

        locadora.alugarFilme(contrato, idFilme);
    }
    
    public static void fluxoVenderFilme(int idFilme, Filme filme, Cliente cliente) {
        ContratoAluguel contrato = new ContratoAluguel(filme, cliente);        
        locadora.venderFilme(contrato, idFilme);
    }
       
    public static void fluxoRegistrarFilme() {
        Saida.cabecalhoFuncionalidade("Registrar Filme");

        Saida.campoDeEntrada("Nome");
        String nome = Entrada.recebeString();

        Saida.campoDeEntrada("Categoria");
        String categoria = Entrada.recebeString();

        Saida.campoDeEntrada("Duracao  (Ex: HH:mm)");
        String duracao = Entrada.recebeString();

        Saida.campoDeEntrada("Preço");
        double preco = Entrada.recebeDouble();

        Saida.campoDeEntrada("Classificação Indicativa");
        int classificacao = Entrada.recebeInt();

        locadora.cadastrarFilme(new Filme(nome, categoria, duracao, preco, classificacao));
        Saida.resultadoFuncao("Cadastro realizado com sucesso!");
        opcaoMenu = Entrada.recebeString();
    }

    public static Cliente fluxoRegistrarCliente() {
        System.out.println("\n\n  |  Preencha o formulário do Cliente  |");
        Saida.campoDeEntrada("Nome do Cliente");
        String nomeCliente = Entrada.recebeString();

        Saida.campoDeEntrada("CPF");
        String cpf = Entrada.recebeString();

        Saida.campoDeEntrada("Telefone");
        String telefone = Entrada.recebeString();

        Cliente cliente = new Cliente(nomeCliente, cpf, telefone);
        locadora.cadastrarCliente(cliente);
        
        return cliente;
    }
}