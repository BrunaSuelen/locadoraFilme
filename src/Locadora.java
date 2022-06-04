

import java.util.ArrayList;


public class Locadora {
	public ArrayList<Filme> filmes;
	public ArrayList<Recibo> recibos;
	
	public Locadora(ArrayList<Filme> filmes) {
		this.recibos = new ArrayList<Recibo>();
		this.filmes = filmes;
	}

	/* Adiciona o filme enviado ao arrayList de filmes 
	 * 
	 * @param filme: Objeto filme já instânciado*/
	public void cadastrarFilme(Filme filme) {
		this.filmes.add(filme);
	}
	
	/* Realiza o processo de locação do filme.
	 * Adicionado o recibo enviado ao arrayList de recibos e alterando status de aluguel do filme
	 * 
	 * @param recibo: Objeto recibo já instância
	 * @param idFilme: Indice de posicionamento do filme no arrayList*/
	public void locarFilme(Recibo recibo, int idFilme) {
		this.filmes.get(idFilme).setAlugado(true);
		this.recibos.add(recibo);
	}

	/* Busca dentro do arrayList de filmes o objeto que possui o mesmo nome passado pelo parâmetro 
	 * 
	 * @param nomeFilme: Nome do filme que deseja encontrar
	 * @return Indice que o filme está posicionado*/
	public int buscarFilme(String nomeFilme) {
		for (int i = 0; i < this.filmes.size(); i++) {
			if (this.filmes.get(i).getNome().equals(nomeFilme)) {
				return i;
			}
		}
		
		return -1;
	}
}
