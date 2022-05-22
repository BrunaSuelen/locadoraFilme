import classes.Filme;
import classes.Locadora;
import uteis.*;


public class Principal {

	public static void main(String[] args) {
		String opcaoMenu;
		Locadora locadora = new Locadora(Rotina.gerarFilmes());

		do {
			Saida.menu();
			opcaoMenu = Entrada.recebeString();
			Saida.limparConsole();

			switch (opcaoMenu) {
				case "1": {
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
				case "2": {
					break;
				}
				case "3": { // Buscar Filme
					Saida.cabecalhoFuncionalidade("Buscar Filme");
					Saida.campoDeEntrada("Informe o nome do filme que deseja");
					String nomeFilmeDesejado = Entrada.recebeString();
					Filme filme = locadora.buscarFilme(nomeFilmeDesejado);
					
					if (filme != null) {
						Saida.limparConsole();
						//filme.exibirFilme();
					} else {
						Saida.resultadoFuncao("Infelizmente, não encontramos o filme :(");
						opcaoMenu = Entrada.recebeString();
						Saida.limparConsole();
					}
					break;
					
				}
			}
		} while (!opcaoMenu.equals("0"));
	}
}
