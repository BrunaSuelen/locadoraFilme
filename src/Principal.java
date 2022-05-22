import classes.Filme;
import classes.Locadora;

import java.io.IOException;
import uteis.*;

public class Principal {

	public static void main(String[] args) throws IOException {
		int opcaoMenu;
		Locadora locadora = new Locadora(Rotina.gerarFilmes());

		do {
			Saida.menu();
			opcaoMenu = Entrada.recebeInt();
			Saida.limparConsole();

			switch (opcaoMenu) {
				case 1: {
					break;
				}
				case 2: {
					break;
				}
				case 3: { // Buscar Filme
					Saida.cabecalhoFuncionalidade("Buscar Filme");
					Saida.campoDeEntrada("Informe o nome do filme que deseja");
					String nomeFilmeDesejado = Entrada.recebeString();
					Filme filmeEncontrado = locadora.buscarFilme(nomeFilmeDesejado);
					break;
				}
				case 0: {
					System.exit(0);
					break;
				}
			}
		} while (opcaoMenu != 0);

	}
}
