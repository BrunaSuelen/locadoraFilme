import java.util.Scanner;
import classes.Filme;
import java.util.ArrayList;
import uteis.*;


public class Principal {
	public static void main(String[] args) {
		ArrayList<Filme> filmes = Rotina.gerarFilmes();
		Saida.menu();
		
		/*
		 * ArrayList<Filme> locadora = new ArrayList<>(); Scanner scan = new
		 * Scanner(System.in); int opcao; Filme f;
		 * 
		 * do { System.out.println("Sistema de registro de filmes");
		 * System.out.println("-------------------------------");
		 * System.out.println("| 1 - Registrar filme        |");
		 * System.out.println("| 2 - listar filme(s)        |");
		 * System.out.println("| 3 - Sair                   |");
		 * System.out.println("-------------------------------");
		 * System.out.println("Digite sua opção"); opcao = scan.nextInt();
		 * 
		 * switch (opcao) {
		 * 
		 * case 1: { f = filme.alugarFilme(); locadora.add(f); break; } case 2: {
		 * filme.exibirLista(locadora); break; } case 3: {
		 * System.out.println("Processo concluído"); break; } } } while (opcao != 3);
		 */

	}
}