package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Filme {
	private String nome, categoria, duracao;
	private float preco;
	private int classificacaoIndicativa;

	public Filme(String nome, String categoria, String duracao, float preco, int classificacaoIndicativa) {
		this.nome = nome;
		this.categoria = categoria;
		this.duracao = duracao;
		this.preco = preco;
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public void exibir() {
		System.out.println("O nome do filme é:" + nome);
		System.out.println("A categoria do filme é" + categoria);
		System.out.println("A duração do filme é" + duracao);
	}

	public static void exibirLista(ArrayList<Filme> locadora) {
		for (int i = 0; i < locadora.size(); i++) {
			locadora.get(i).exibir();
		}
	}

	public static Filme alugarFilme() {
		Scanner scan = new Scanner(System.in);
		Filme f;
		String nom;
		String cat;
		String dur;
		float pre;
		int cla;

		System.out.println("Informe o nome do filme :");
		nom = scan.next();
		System.out.println("Informe a categoria do filme :");
		cat = scan.next();
		System.out.println("Informe a duração do filme :");
		dur = scan.next();
		System.out.println("Informe o preço do filme :");
		pre = scan.nextFloat();
		System.out.println("Informe a classificação indicaitva do filme :");
		cla = scan.nextInt();

		f = new Filme(nom, cat, dur, pre, cla);
		return f;

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

}