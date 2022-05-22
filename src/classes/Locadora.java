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

	public void cadastrarFilme(Filme filme) {
		this.filmes.add(filme);
	}

	public Filme buscarFilme(String nomeFilme) {
		for (int i = 0; i < this.filmes.size(); i++) {
			if (this.filmes.get(i).getNome().equals(nomeFilme)) {
				return this.filmes.get(i);
			}
		}
		
		return null;
	}
}
