import classes.Filme;
import classes.Locadora;
import classes.Recibo;
import uteis.*;


public class Principal {

//	public static void main(String[] args) {
//		Locadora locadora = new Locadora(Rotina.gerarFilmes());
//		Saida.listarRecibos(locadora.recibos);
//	}
	
	public static void main(String[] args) {
		String opcaoMenu;
		Locadora locadora = new Locadora(Rotina.gerarFilmes());

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
					Saida.limparConsole();
					break;
					
				}
				case "2": {// Listar Filme
					Saida.cabecalhoFuncionalidade("Listar Filme");
					Saida.listarFilmes(locadora.filmes);
					opcaoMenu = Entrada.recebeString();
					Saida.limparConsole();
					break;
				}
				case "3": { // Locar Filme
					Saida.cabecalhoFuncionalidade("Buscar Filme");
					Saida.campoDeEntrada("Informe o nome do filme que deseja");
					String nomeFilmeDesejado = Entrada.recebeString();
					int idFilme = locadora.buscarFilme(nomeFilmeDesejado);
					
					if (idFilme != -1) {
						Filme filme = locadora.filmes.get(idFilme);
						Saida.exibirDetalhesFilme(filme);
						Saida.campoDeEntrada("Deseja Alocar? | Sim (Enter) |  | Não (0) |");
						String alocarFilme = Entrada.recebeString();
						
						if (!alocarFilme.equals("0")) {
							Saida.campoDeEntrada("Nome do Cliente");
							String nomeCliente = Entrada.recebeString();

							Saida.campoDeEntrada("Data da Locação");
							String dataLocacao = Entrada.recebeString();

							Saida.campoDeEntrada("Data de Devolução");
							String dataDevolucao = Entrada.recebeString();
							
							Recibo recibo = new Recibo(filme, nomeCliente, dataLocacao, dataDevolucao);
							locadora.locarFilme(recibo, idFilme);
							Saida.resultadoFuncao("Filme alocado com sucesso!");
							opcaoMenu = Entrada.recebeString();
						}
						
						Saida.limparConsole();
					} else {
						Saida.resultadoFuncao("Infelizmente, não encontramos o filme :(");
						opcaoMenu = Entrada.recebeString();
						Saida.limparConsole();
					}
					
					break;			
				}
				case "4": {// Listar Recibos
					Saida.cabecalhoFuncionalidade("Listar Recibos");
					Saida.listarRecibos(locadora.recibos);
					opcaoMenu = Entrada.recebeString();
					Saida.limparConsole();
					break;
				}
			}
		} while (!opcaoMenu.equals("0"));
		
		System.exit(0);
	}

}
