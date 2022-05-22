package uteis;

import java.util.ArrayList;

import classes.Filme;


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
	
	public static void limparConsole() {
		for (int i = 0; i < 5; i++) {
			System.out.println("\n");
		}
    }
	
	public static void resultadoFuncao(String mensagem) {
		System.out.println("\n\n  -----------------------------------------------");
		System.out.println("  ** "+ mensagem +" **");
		System.out.println("  -----------------------------------------------\n");
		System.out.print("    | Menu (Enter) | \t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	public static void listarFilmes(ArrayList<Filme> filmes) {
		System.out.println("\n\n");		
		System.out.println("  || Cod. | Nome   \t\t\t\t|   Preço   |  Alocado  ||");
		System.out.println("  ||----------------------------------------------------------------------||");
		
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			System.out.print("  || "+ i);
			celulaDaTabela(5, String.valueOf(i));
			
			System.out.print(" "+ filme.getNome());
			celulaDaTabela(38, filme.getNome());

			System.out.print(" "+ filme.getPreco());
			celulaDaTabela(10, String.valueOf(filme.getPreco()));

			String statusAlugado = filme.getAlugado() ? "Sim" : "Não";
			System.out.print(" "+ statusAlugado);
			celulaDaTabela(10, statusAlugado);
			System.out.println("|");
		}

		System.out.print("\n\n\t");
		System.out.print("| Menu (Enter) |");
		System.out.print(" \t\t\t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	public static void celulaDaTabela(int limite, String valor) {
		int quantidadeEspaco = limite - valor.length();
		
		for (int i = 0; i < quantidadeEspaco; i++) {
			System.out.print(" ");
		}
		System.out.print("|");
	}
}
