package uteis;

import java.util.ArrayList;

import classes.Filme;
import classes.Recibo;


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
		System.out.println("  | 2 |  Listar Filmes");
		System.out.println("  | 3 |  Locar Filme");
		System.out.println("  | 4 |  Listar Recibos");
		System.out.println("  | 0 |  Sair");
		campoDeEntrada("Digite a opção desejada");
	}

	public static void listarFilmes(ArrayList<Filme> filmes) {
		System.out.print("\n  || Cod. | Nome   \t\t\t\t|   Preço   |  Alocado  ||");
		linhaTabela(70);
		
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			System.out.print("  || "+ i);
			preencheEspacoFaltante(5, String.valueOf(i), " ");
			
			System.out.print("| "+ filme.getNome());
			preencheEspacoFaltante(38, filme.getNome(), " ");

			System.out.print("| "+ filme.getPreco());
			preencheEspacoFaltante(10, String.valueOf(filme.getPreco()), " ");

			String statusAlugado = filme.getAlugado() ? "Sim" : "Não";
			System.out.print("| "+ statusAlugado);
			preencheEspacoFaltante(10, statusAlugado, " ");
			System.out.print("||");
		}
		linhaTabela(70);
		System.out.print("\n\n\t");
		System.out.print("| Menu (Enter) |");
		System.out.print(" \t\t\t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	public static void listarRecibos(ArrayList<Recibo> recibos) {
		System.out.print("\n  || Cod. | Nome Cliente   \t\t|   Locação em   |  Devolução em  ||");
		linhaTabela(70);
		
		for (int i = 0; i < 1; i++) {
			Recibo recibo = recibos.get(i);
			System.out.print("  || "+ i);
			preencheEspacoFaltante(5, String.valueOf(i), " ");
//			System.out.print("| "+ "Bruna");
//			preencheEspacoFaltante(28, "Bruna", " ");
//
//			System.out.print("| "+ "20");
//			preencheEspacoFaltante(15, "20", " ");
//
//			System.out.print("| "+ "20");
//			preencheEspacoFaltante(15, "20", " ");
			
			System.out.print("| "+ recibo.getNomeCliente());
			preencheEspacoFaltante(28, recibo.getNomeCliente(), " ");

			System.out.print("| "+ recibo.getDataLocacao());
			preencheEspacoFaltante(15, String.valueOf(recibo.getDataLocacao()), " ");

			System.out.print("| "+ recibo.getDataDevolucao());
			preencheEspacoFaltante(15, String.valueOf(recibo.getDataDevolucao()), " ");

			System.out.print("||");
		}
		linhaTabela(70);
		System.out.print("\n\n\t");
		System.out.print("| Menu (Enter) |");
		System.out.print(" \t\t\t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	public static void campoDeEntrada(String descricaoCampo) {
		System.out.print("\n  >>  "+ descricaoCampo +": ");
	}
	
	public static void limparConsole() {
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
    }

	public static void resultadoFuncao(String mensagem) {
		if (!mensagem.equals("")) {
			System.out.println("\n\n  -----------------------------------------------");
			System.out.println("    ** "+ mensagem +" **");
			System.out.println("  -----------------------------------------------\n");
		}
		
		System.out.print("    | Menu (Enter) | \t");
		System.out.print("  | Sair (0) | \t >");
	}

	public static void exibirAtributoDetalhesFilme(String atributo, String valor) {
		System.out.print("\n  ||\t" + atributo);
		preencheEspacoFaltante(20, atributo, " ");
		System.out.print(":    " + valor);
		preencheEspacoFaltante(19, valor, " ");
		System.out.print("||");
	}

	public static void exibirDetalhesFilme(Filme filme) {
		String statusAlugado = filme.getAlugado() ? "Sim" : "Não";

		System.out.print("\n  ");
		centralizarValor("DETALHES DO FILME", 50, "||", " ");		
		linhaTabela(50);
		System.out.print("  ");
		
		centralizarValor(filme.getNome(), 50, "||", " ");
		pularLinhaTabela(50);
		
		exibirAtributoDetalhesFilme("Categoria", filme.getCategoria());	
		exibirAtributoDetalhesFilme("Duração", filme.getDuracao());	
		exibirAtributoDetalhesFilme("Preço", String.valueOf(filme.getPreco()));	
		exibirAtributoDetalhesFilme("Classificação", String.valueOf(filme.getClassificacaoIndicativa()));
		exibirAtributoDetalhesFilme("Alugado", statusAlugado);

		pularLinhaTabela(50);
		linhaTabela(50);
		System.out.print("\n");
	}
	
	public static void centralizarValor(String valor, int espacoTotal, String separador, String caracterEspaco) {
		int espacoFaltante = (espacoTotal - valor.length()) / 2;
		System.out.print(separador);
		preencheEspacoFaltante(espacoFaltante, "", caracterEspaco);
		System.out.print(valor);
		preencheEspacoFaltante(espacoTotal - valor.length() - espacoFaltante , "", caracterEspaco);
		System.out.print(separador);
	}

	public static void linhaTabela(int quantidade) {
		System.out.print("\n  ||");
		preencheEspacoFaltante(quantidade, "", "-");
		System.out.print("||\n");
	}
	
	public static void pularLinhaTabela(int quantidade) {
		System.out.print("\n  ");
		centralizarValor(" ", quantidade, "||", " ");
	}
	
	/*
	 * Método que calcula quandos caracteres faltam para alcançar um determinado
	 * limite
	 * 
	 * @param limite - Define a quantidade máxima de caracteres á serem impressos
	 * @param valor - String já existente que será utilizada para calcular espaço faltante
	 * @param caracter - Caracter que será repetido no espaço faltante
	 */
	public static void preencheEspacoFaltante(int limite, String valor, String caracter) {
		int espacoFaltante = limite - valor.length();
		
		for (int i = 0; i < espacoFaltante; i++) {
			System.out.print(caracter);
		}
	}
}
