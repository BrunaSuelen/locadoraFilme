import java.math.BigDecimal;

public class Filme {

    private static double TAXA_VENDA = 1.5;
    private static double TAXA_DIA_ADICIONAL = 0.4;

    private String nome, categoria, duracao;
    private double preco;
    private double precoDiaExtra;
    private int classificacaoIndicativa;
    private boolean alugado;
    private int tempoAluguel;

    public Filme(String nome, String categoria, String duracao, double preco, int classificacaoIndicativa, int tempoAluguel) {
        this.nome = nome;
        this.categoria = categoria;
        this.duracao = duracao;
        this.preco = preco;
        this.precoDiaExtra = getPrecoDiaAdicional();
        this.classificacaoIndicativa = classificacaoIndicativa;
        this.tempoAluguel = tempoAluguel;
        this.alugado = false;
    }
    
    public Filme(String nome, String categoria, String duracao, double preco, int classificacaoIndicativa, boolean alugado, int tempoAluguel) {
        this(nome, categoria, duracao, preco, classificacaoIndicativa, tempoAluguel);
        this.alugado = alugado;
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

    public int getTempoAluguel() {
        return tempoAluguel;
    }

    public void setTempoAluguel(int tempoAluguel) {
        this.tempoAluguel = tempoAluguel;
    }

    public boolean getAlugado() {
        return alugado;
    }

    public void setAlugado(boolean alugado) {
        this.alugado = alugado;
    }

    public double getPrecoDiaExtra() {
        return precoDiaExtra;
    }

    public void setPrecoDiaExtra(double precoDiaExtra) {
        this.precoDiaExtra = precoDiaExtra;
    }

    public double getPrecoVenda() {
        double preco = TAXA_VENDA * this.preco;
        BigDecimal precoBigDecimal = new BigDecimal(preco);
        precoBigDecimal = precoBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return precoBigDecimal.doubleValue();
    }

    public double getPrecoDiaAdicional() {
        double preco = TAXA_DIA_ADICIONAL * this.preco;
        BigDecimal precoBigDecimal = new BigDecimal(preco);
        precoBigDecimal = precoBigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);	
        return precoBigDecimal.doubleValue();
    }
  
    /* Imprime detalhes do filme */
    public void exibirDetalhesFilme() {
        System.out.print("\n  ");
        Saida.centralizarValor("DETALHES DO FILME", 50, "||", " ");
        Saida.linhaTabela(50);
        System.out.print("  ");

        Saida.centralizarValor(this.nome, 50, "||", " ");
        Saida.pularLinhaTabela(50);

        Saida.exibirAtributoDetalhesObjeto("Categoria", this.categoria);
        Saida.exibirAtributoDetalhesObjeto("Duração", this.duracao);
        Saida.exibirAtributoDetalhesObjeto("Classificação", String.valueOf(this.classificacaoIndicativa));
        Saida.exibirAtributoDetalhesObjeto("Tempo de Aluguel", String.valueOf(this.tempoAluguel));
        Saida.exibirAtributoDetalhesObjeto("Preço", "R$ " + String.valueOf(this.preco));
        Saida.exibirAtributoDetalhesObjeto("Preço Venda", "R$ " + String.valueOf(this.getPrecoVenda()));
        Saida.exibirAtributoDetalhesObjeto("Taxa dia Adicional", "R$ " +String.valueOf(this.precoDiaExtra));
        Saida.exibirAtributoDetalhesObjeto("Alugado", this.alugado ? "Sim" : "Não");

        Saida.pularLinhaTabela(50);
        Saida.linhaTabela(50);
        System.out.print("\n");
    }
}
