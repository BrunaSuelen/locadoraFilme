package classes;

import java.util.ArrayList;
import uteis.Rotina;

public class Locadora {
	public ArrayList<Filme> filmes;
	
	public Locadora(ArrayList<Filme> filmes) {
		this.filmes = filmes;
	}
  
//	public void listarFilmes() {
//		for (int i = 0; i < locadora.size(); i++) {
//			locadora.get(i).exibir();
//		}
//	}

	public Filme buscarFilme(String nomeFilme) {
		for (int i = 0; i < this.filmes.size(); i++) {
			if (this.filmes.get(i).getNome().equals(nomeFilme)) {
				return this.filmes.get(i);
			}
		}
		
		return null;
	}

//	public Filme alugarFilme() {
//		Scanner scan = new Scanner(System.in);
//		Filme f;
//		String nom;
//		String cat;
//		String dur;
//		float pre;
//		int cla;
//	
//		System.out.println("Informe o nome do filme :");
//		nom = scan.next();
//		System.out.println("Informe a categoria do filme :");
//		cat = scan.next();
//		System.out.println("Informe a duração do filme :");
//		dur = scan.next();
//		System.out.println("Informe o preço do filme :");
//		pre = scan.nextFloat();
//		System.out.println("Informe a classificação indicaitva do filme :");
//		cla = scan.nextInt();
//	
//		f = new Filme(nom, cat, dur, pre, cla);
//		return f;
//	
//	}
}
