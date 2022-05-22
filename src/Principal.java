import classes.Filme;
import classes.Locadora;
import java.io.IOException;
import uteis.*;


public class Principal {

	public static void main(String[] args) throws InterruptedException, IOException {
		String opcaoMenu;
		Locadora locadora = new Locadora(Rotina.gerarFilmes());

		do {
			Saida.menu();
			opcaoMenu = Entrada.recebeString();
			Saida.limparConsole();

			switch (opcaoMenu) {
				case "1": {
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
