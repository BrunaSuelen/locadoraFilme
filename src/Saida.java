import java.util.ArrayList;

public class Saida {
	
	/* Imprime interface de cabeçalho do sistema */
	public static void cabecalho() {
		System.out.println("\n  :::       LOCADORA DE FILMES       :::");
		System.out.println("  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
	}
	
	/* Imprime interface de cabeçalho e nome da função do sistema */
	public static void cabecalhoFuncionalidade(String funcao) {
		cabecalho();
		System.out.println("\t    "+ funcao + "\n");
	}
	
	/* Imprime interface do menu */
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

	/* Imprime uma tabela de filmes previamente cadastrados
	 * 
	 *  @param filmes*/
	public static void listarFilmes(ArrayList<Filme> filmes) {
		//Imprime o cabeçalho da tabela
		System.out.print("\n  || Cod. | Nome   \t\t\t\t|   Preço   |  Locado  ||");
		linhaTabela(68);
		
		//Preenche linha da tabela com os atributos do filme
		for (int i = 0; i < filmes.size(); i++) {
			Filme filme = filmes.get(i);
			System.out.print("  || "+ i);
			preencheEspacoFaltante(5, String.valueOf(i), " ");
			
			System.out.print("| "+ filme.getNome());
			preencheEspacoFaltante(36, filme.getNome(), " ");

			System.out.print("| "+ filme.getPreco());
			preencheEspacoFaltante(10, String.valueOf(filme.getPreco()), " ");

			String statusAlugado = filme.getAlugado() ? "Sim" : "Não";
			System.out.print("| "+ statusAlugado);
			preencheEspacoFaltante(10, statusAlugado, " ");
			System.out.println("||");
		}
		linhaTabela(68);
		System.out.print("\n\n\t");
		System.out.print("| Menu (Enter) |");
		System.out.print(" \t\t\t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	/* Imprime uma tabela de recibos previamente cadastrados
	 * 
	 *  @param recibos*/
	public static void listarRecibos(ArrayList<Recibo> recibos) {
		//Imprime o cabeçalho da tabela
		System.out.print("\n  || Cod. | Nome Cliente   \t\t|   Locação em   |  Devolução em  ||");
		linhaTabela(70);
		

		if (recibos.isEmpty()) {
			centralizarValor("Nenhum recibo encontrado", 68, "  ||", " ");
		
		} else {
			//Preenche linha da tabela com os atributos do recibo
			for (int i = 0; i < recibos.size(); i++) {
				Recibo recibo = recibos.get(i);
				System.out.print("  || "+ i);
				preencheEspacoFaltante(5, String.valueOf(i), " ");
				
				System.out.print("| "+ recibo.getNomeCliente());
				preencheEspacoFaltante(28, recibo.getNomeCliente(), " ");
	
				System.out.print("| "+ recibo.getDataLocacao());
				preencheEspacoFaltante(15, String.valueOf(recibo.getDataLocacao()), " ");
	
				System.out.print("| "+ recibo.getDataDevolucao());
				preencheEspacoFaltante(15, String.valueOf(recibo.getDataDevolucao()), " ");
	
				System.out.print("||");
			}
		}
		
		linhaTabela(70);
		System.out.print("\n\n\t");
		System.out.print("| Menu (Enter) |");
		System.out.print(" \t\t\t");
		System.out.print("  | Sair (0) | \t >");
	}
	
	/* Imprime interface do campo de entrada para o usuário
	 * 
	 *  @param descricaoCampo: Nome do campo que o usuário irá preencher*/
	public static void campoDeEntrada(String descricaoCampo) {
		System.out.print("\n  >>  "+ descricaoCampo +": ");
	}
	
	/* Imprime feedback sobre resultado da função
	 * 
	 *  @param mensagem: Mensagem que descreve resultado da função*/
	public static void resultadoFuncao(String mensagem) {
		if (!mensagem.equals("")) {
			System.out.println("\n\n  -----------------------------------------------");
			System.out.println("    ** "+ mensagem +" **");
			System.out.println("  -----------------------------------------------\n");
		}
		
		System.out.print("    | Menu (Enter) | \t");
		System.out.print("  | Sair (0) | \t >");
	}

	/* Imprime feedback sobre resultado da função
	 * 
	 *  @param mensagem: Mensagem que descreve resultado da função*/
	public static void detalhesFilme(Filme filme) {
		String statusAlugado = filme.getAlugado() ? "Sim" : "Não";

		System.out.print("\n  ");
		centralizarValor("DETALHES DO FILME", 50, "||", " ");		
		linhaTabela(50);
		System.out.print("  ");
		
		centralizarValor(filme.getNome(), 50, "||", " ");
		pularLinhaTabela(50);
		
		atributoDetalhesFilme("Categoria", filme.getCategoria());	
		atributoDetalhesFilme("Duração", filme.getDuracao());	
		atributoDetalhesFilme("Preço", String.valueOf(filme.getPreco()));	
		atributoDetalhesFilme("Classificação", String.valueOf(filme.getClassificacaoIndicativa()));
		atributoDetalhesFilme("Alugado", statusAlugado);

		pularLinhaTabela(50);
		linhaTabela(50);
		System.out.print("\n");
	}
	
	public static void atributoDetalhesFilme(String atributo, String valor) {
		System.out.print("\n  ||\t" + atributo);
		preencheEspacoFaltante(20, atributo, " ");
		System.out.print(":    " + valor);
		preencheEspacoFaltante(21, valor, " ");
		System.out.print("||");
	}

	/* Método que calcula quandos caracteres faltam para alcançar um determinado
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
	
	/* Calcula espaços iniciais e finais para que o teexto enviado fica centralizado
	 * 
	 *  @param valor: Texto que será exibido
	 *  @param espacoTotal: Espaço em que o texto deve se basear para posicionar ao centro
	 *  @param separador: Caracter que irá delimitar inicio e fim do espaço total
	 *  @param caracterEspaco: Caracter que deve preencher o espaço entre a texto centralizado e o separador*/
	public static void centralizarValor(String valor, int espacoTotal, String separador, String caracterEspaco) {
		int espacoFaltante = (espacoTotal - valor.length()) / 2;
		System.out.print(separador);
		preencheEspacoFaltante(espacoFaltante, "", caracterEspaco);
		System.out.print(valor);
		preencheEspacoFaltante(espacoTotal - valor.length() - espacoFaltante , "", caracterEspaco);
		System.out.print(separador);
	}

	/* Inprime uma linha horizontal na tabela */
	public static void linhaTabela(int quantidade) {
		System.out.print("\n  ||");
		preencheEspacoFaltante(quantidade, "", "-");
		System.out.print("||\n");
	}

	/* Inprime uma linha vazia na tabela */
	public static void pularLinhaTabela(int quantidade) {
		System.out.print("\n  ");
		centralizarValor(" ", quantidade, "||", " ");
	}

	public static void limparConsole() {
		for (int i = 0; i < 10; i++) {
			System.out.println("\n");
		}
    }

}
