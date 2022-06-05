import java.time.Instant;
import java.util.Calendar;
import java.util.Date;


public class Principal {
    
    public static void main(String[] args) {
        Cliente cliente = new Cliente("teste", "7890", "dfgh@dftgy.hui");
        Saida.cabecalhoFuncionalidade("Buscar Filme");
        Saida.campoDeEntrada("Informe o código do cliente responsável");
        System.out.println("\n\n  |  Preencha o formulário de aluguel  |");

        Saida.campoDeEntrada("Nome do Cliente");
//      String nomeCliente = Entrada.recebeString();

        Saida.campoDeEntrada("Data de Devolução (Ex: dd/mm/aaaa)");
        String dataDevolucao = Entrada.recebeString();

        ContratoAluguel recibo = new ContratoAluguel(new Filme("Invocação do mal","Terror","1:30",18, 12), cliente);
        
        System.out.println(recibo.setDataDevolucao(dataDevolucao));
        int erro = recibo.setDataDevolucao(dataDevolucao);
        
        if (erro == 0) {
            System.out.println("Sucesso");
        } else {
            Saida.exibirErro(recibo.mensagemErroValidacaoDataDevolucao(erro));
        }
//        locadora.alugarFilme(recibo, idFilme);
//        Saida.resultadoFuncao("Filme alugado com sucesso!");
//        opcaoMenu = Entrada.recebeString();
    }

//    public static void main(String[] args) {
//        String opcaoMenu;
//        Locadora locadora = new Locadora();
//        Calendar date = Calendar.getInstance();
//        
//        // Repete exibição de menu caso o usuário solicite
//        do {
//            Saida.menu();
//            opcaoMenu = Entrada.recebeString();
//            Saida.limparConsole();
//
//            switch (opcaoMenu) {
//                case "1": { // Registrar Filme
//                    Saida.cabecalhoFuncionalidade("Registrar Filme");
//
//                    Saida.campoDeEntrada("Nome");
//                    String nome = Entrada.recebeString();
//
//                    Saida.campoDeEntrada("Categoria");
//                    String categoria = Entrada.recebeString();
//
//                    Saida.campoDeEntrada("Duracao  (Ex: HH:mm)");
//                    String duracao = Entrada.recebeString();
//
//                    Saida.campoDeEntrada("Preço");
//                    double preco = Entrada.recebeDouble();
//
//                    Saida.campoDeEntrada("Classificação Indicativa");
//                    int classificacao = Entrada.recebeInt();
//
//                    locadora.cadastrarFilme(new Filme(nome, categoria, duracao, preco, classificacao));
//                    Saida.resultadoFuncao("Cadastro realizado com sucesso!");
//                    opcaoMenu = Entrada.recebeString();
//                    break;
//
//                }
//                case "2": {// Listar Filmes
//                    Saida.cabecalhoFuncionalidade("Listar Filmes");
//                    locadora.listarFilmes();
//                    opcaoMenu = Entrada.recebeString();
//                    break;
//                }
//                case "3": { // Alugar Filme
//                    Saida.cabecalhoFuncionalidade("Buscar Filme");
//                    Saida.campoDeEntrada("Informe o nome do filme que deseja");
//                    String nomeFilmeDesejado = Entrada.recebeString();
//                    int idFilme = locadora.buscarFilme(nomeFilmeDesejado);
//
//                    if (idFilme != -1) {
//                        Filme filme = locadora.filmes.get(idFilme);
//                        filme.exibirDetalhesFilme();
//
//                        if (filme.getAlugado()) {
//                            Saida.resultadoFuncao("Este filme já está alugado :/");
//                            opcaoMenu = Entrada.recebeString();
//
//                        } else {
//                            Saida.campoDeEntrada("Deseja alugar?    | Sim (Enter) |     | Não (0) |");
//                            String alugarFilme = Entrada.recebeString();
//
//                            if (!alugarFilme.equals("0")) {
//                                System.out.println("\n\n  |  Preencha o formulário de aluguel  |");
//                                String dataLocacao = date.get(Calendar.DATE) + "." + date.get(Calendar.MONTH) + "."
//                                        + date.get(Calendar.YEAR);
//
//                                Saida.campoDeEntrada("Nome do Cliente");
//                                String nomeCliente = Entrada.recebeString();
//
//                                Saida.campoDeEntrada("Data de Devolução (Ex: dd.mm.aaaa)");
//                                String dataDevolucao = Entrada.recebeString();
//
////                                Contrato recibo = new Contrato(filme, nomeCliente, dataLocacao, dataDevolucao);
////                                locadora.alugarFilme(recibo, idFilme);
////                                Saida.resultadoFuncao("Filme alugado com sucesso!");
////                                opcaoMenu = Entrada.recebeString();
//                            }
//                        }
//
//                    } else {
//                        Saida.resultadoFuncao("Infelizmente, não encontramos o filme :(");
//                        opcaoMenu = Entrada.recebeString();
//                    }
//                    break;
//                }
//                case "4": {// Listar Recibos
//                    Saida.cabecalhoFuncionalidade("Listar Recibos");
//                    locadora.listarContratosAluguel();
//                    opcaoMenu = Entrada.recebeString();
//                    break;
//                }
//            }
//
//            Saida.limparConsole();
//        } while (!opcaoMenu.equals("0"));
//
//        System.exit(0);
//    }
}
