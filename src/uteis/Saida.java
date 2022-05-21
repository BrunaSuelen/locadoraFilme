package uteis;

public class Saida {
	
	public static void cabecalho() {
		System.out.println("\n  :::   LOCADORA DE FILMES   :::");
		System.out.println("  ==============================\n");
	}

	public static void menu() {
		cabecalho();
		System.out.println("  | 1 |  Registrar filmes");
		System.out.println("  | 2 |  Listar filme(s)");
		System.out.println("  | 3 |  Sair");
		System.out.println("\n  ______________________________");
		System.out.println("  >> Digite a opção desejada: ");
	}
}
