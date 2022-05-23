package classes;

import java.util.ArrayList;
import java.util.Scanner;


public class Filme {
	private String nome, categoria, duracao;
	private double preco;
	private int classificacaoIndicativa;
	private boolean alugado;

	public Filme(String nome, String categoria, String duracao, double preco, int classificacaoIndicativa) {
		this.nome = nome;
		this.categoria = categoria;
		this.duracao = duracao;
		this.preco = preco;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.alugado = false;
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getClassificacaoIndicativa() {
		return classificacaoIndicativa;
	}

	public void setClassificacaoIndicativa(int classificacaoIndicativa) {
		this.classificacaoIndicativa = classificacaoIndicativa;
	}

	public boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(boolean alugado) {
		this.alugado = alugado;
	}
}