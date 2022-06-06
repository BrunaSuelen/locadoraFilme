public class Saida {

    /* Imprime interface de cabeçalho do sistema */
    public static void cabecalho() {
        System.out.println("\n  :::       LOCADORA DE FILMES       :::");
        System.out.println("  ¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
    }

    /* Imprime interface de cabeçalho e nome da função do sistema */
    public static void cabecalhoFuncionalidade(String funcao) {
        cabecalho();
        System.out.println("\t    " + funcao + "\n");
    }

    /* Imprime interface do menu */
    public static void menu() {
        cabecalho();
        System.out.println("\n");
        System.out.println("  | 1 |  Registrar Filme");
        System.out.println("  | 2 |  Listar Filmes");
        System.out.println("  | 3 |  Listar Filmes Atrasados");
        System.out.println("  | 4 |  Alugar Filme");
        System.out.println("  | 5 |  Listar Recibos");
        System.out.println("  | 6 |  Listar Clientes");
        System.out.println("  | 7 |  Registrar Cliente");
        System.out.println("  | 0 |  Sair");
        campoDeEntrada("Digite a opção desejada");
    }

    /* Imprime interface do campo de entrada para o usuário
	 * 
	 *  @param descricaoCampo: Nome do campo que o usuário irá preencher*/
    public static void campoDeEntrada(String descricaoCampo) {
        System.out.print("\n  >>  " + descricaoCampo + ": ");
    }

    /* Imprime feedback sobre resultado da função
	 * 
	 *  @param mensagem: Mensagem que descreve resultado da função*/
    public static void resultadoFuncao(String mensagem) {
        if (!mensagem.equals("")) {
            System.out.println("\n\n  -----------------------------------------------");
            System.out.println("    ** " + mensagem + " **");
            System.out.println("  -----------------------------------------------\n");
        }

        System.out.print("    | Menu (Enter) | \t");
        System.out.print("  | Sair (0) | \t >");
    }
    
    public static void exibirBotoesDeAcao() {
        System.out.print("\n\n\t");
        System.out.print("| Menu (Enter) |");
        System.out.print(" \t\t\t");
        System.out.print("  | Sair (0) | \t >");
    }
    
    public static void exibirAtributoDetalhesObjeto(String atributo, String valor) {
        System.out.print("\n  ||\t" + atributo);
        preencheEspacoFaltante(20, atributo, " ");
        System.out.print(":    " + valor);
        preencheEspacoFaltante(21, valor, " ");
        System.out.print("||");
    }

    public static void exibirErro(String mensagemErro) {
        System.out.println("\n  *** " + mensagemErro + " ***");
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
        preencheEspacoFaltante(espacoTotal - valor.length() - espacoFaltante, "", caracterEspaco);
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
