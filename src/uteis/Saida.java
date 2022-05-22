package uteis;

import java.io.IOException;


public class Saida {
	
	public static void cabecalho() {
		System.out.println("\n  :::       LOCADORA DE FILMES       :::");
		System.out.println("  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
	}
	
	public static void cabecalhoFuncionalidade(String funcao) {
		cabecalho();
		System.out.println("\t    "+ funcao + "\n");
	}
	
	public static void menu() {
		cabecalho();
		System.out.println("\n");
		System.out.println("  | 1 |  Registrar Filme");
		System.out.println("  | 2 |  Listar Filme(s)");
		System.out.println("  | 3 |  Buscar Filme");
		System.out.println("  | 0 |  Sair");
		campoDeEntrada("Digite a opção desejada");
	}
	
	
	public static void campoDeEntrada(String descricaoCampo) {
		System.out.print("\n  >>  "+ descricaoCampo +": ");
	}
	
	public static void limparConsole() throws InterruptedException, IOException {
		for (int i = 0; i < 5; i++) {
			System.out.println("\n");
		}
    }
	
	public static void resultadoFuncao(String mensagem) {
		System.out.println("\n\n  ** "+ mensagem +" **  \n");
		System.out.print("    | Menu (Enter) | \t");
		System.out.print("  | Sair (0) | \t >");
	}
}
