package classes;

import java.util.ArrayList;
import uteis.Rotina;


public class Locadora {
	public ArrayList<Filme> filmes;
	public ArrayList<Recibo> recibos;
	
	public Locadora(ArrayList<Filme> filmes) {
		this.filmes = filmes;
		this.recibos = new ArrayList<Recibo>();
	}

	public void cadastrarFilme(Filme filme) {
		this.filmes.add(filme);
	}
	
	public void locarFilme(Recibo recibo, int idFilme) {
		this.filmes.get(idFilme).setAlugado(true);
		this.recibos.add(recibo);
	}

	public int buscarFilme(String nomeFilme) {
		for (int i = 0; i < this.filmes.size(); i++) {
			if (this.filmes.get(i).getNome().equals(nomeFilme)) {
				return i;
			}
		}
		
		return -1;
	}
}
