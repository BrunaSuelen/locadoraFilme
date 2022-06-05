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
                    break;

                }
                case "2": {// Listar Filmes
                    Saida.cabecalhoFuncionalidade("Listar Filmes");
                    locadora.listarFilmes();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "3": { // Alugar Filme
                    alugarFilme();
                    break;
                }
                case "4": {// Listar Recibos
                    Saida.cabecalhoFuncionalidade("Listar Recibos");
                    locadora.listarContratosAluguel();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
                case "5": {// Listar Clientes
                    Saida.cabecalhoFuncionalidade("Listar Clientes");
                    locadora.listarClientes(false);
                    Saida.exibirBotoesDeAcao();
                    opcaoMenu = Entrada.recebeString();
                    break;
                }
            }

            Saida.limparConsole();
        } while (!opcaoMenu.equals("0"));

        System.exit(0);
    }
    
    public static void alugarFilme() {
        Saida.cabecalhoFuncionalidade("Buscar Filme");
        Saida.campoDeEntrada("Informe o nome do filme que deseja");
        String nomeFilmeDesejado = Entrada.recebeString();
        int idFilme = locadora.buscarFilme(nomeFilmeDesejado);

        if (idFilme != -1) {
            Filme filme = locadora.filmes.get(idFilme);
            filme.exibirDetalhesFilme();

            if (filme.getAlugado()) {
                Saida.resultadoFuncao("Este filme já está alugado :/");
                opcaoMenu = Entrada.recebeString();

            } else {
                Saida.campoDeEntrada("Deseja alugar?    | Sim (Enter) |     | Não (0) |");
                String alugarFilme = Entrada.recebeString();

                if (!alugarFilme.equals("0")) {
                    Cliente cliente = null;
                    boolean clienteInvalido = true;
                    locadora.listarClientes(true);
                    Saida.campoDeEntrada("Informe o código do cliente ou digite 0 para cadastrar um novo");
                    String clienteSelecionado = Entrada.recebeString();

                    do {
                        if (clienteSelecionado.equals("0")) {
                            System.out.println("\n\n  |  Preencha o formulário do Cliente  |");
                            Saida.campoDeEntrada("Nome do Cliente");
                            String nomeCliente = Entrada.recebeString();

                            Saida.campoDeEntrada("CPF");
                            String cpf = Entrada.recebeString();

                            Saida.campoDeEntrada("Telefone");
                            String telefone = Entrada.recebeString();

                            cliente = new Cliente(nomeCliente, cpf, telefone);
                            locadora.cadastrarCliente(cliente);
                            clienteInvalido = false;
                        } else {
                            int codCliente = Integer.parseInt(clienteSelecionado) - 1;
                                
                            if (locadora.clientes.size() >= codCliente) {
                                cliente = locadora.clientes.get(codCliente);
                                clienteInvalido = false;                                
                            } else {
                            Saida.exibirErro("Código inválido");
                            }
                        }                        
                    } while(clienteInvalido);

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
                    Saida.resultadoFuncao("Filme alugado com sucesso!");
                    opcaoMenu = Entrada.recebeString();
                }
            }
        } else {
            Saida.resultadoFuncao("Infelizmente, não encontramos o filme :(");
            opcaoMenu = Entrada.recebeString();
        }
    }
}