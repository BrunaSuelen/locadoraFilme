

public class Recibo {
	private Filme filme;
	private String nomeCliente;
	private String dataLocacao;
	private String dataDevolucao;

	public Recibo(Filme filme, String nomeCliente, String dataLocacao, String dataDevolucao) {
		this.filme = filme;
		this.nomeCliente = nomeCliente;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

}
