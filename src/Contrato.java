
public class Contrato {

    private Filme filme;
    private Cliente cliente;
    private String dataLocacao;
    private String dataDevolucao;

    public Contrato(Filme filme, Cliente cliente, String dataLocacao, String dataDevolucao) {
        this.filme = filme;
        this.cliente = cliente;
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
        return cliente.getNome();
    }

    public void setNomeCliente(Cliente nomeCliente) {
        this.cliente = nomeCliente;
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
