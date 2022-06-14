import java.util.Calendar;
import java.util.Date;

public class ContratoAluguel extends Contrato {    
    private Date dataDevolucao;
    private boolean devolvido;
    private int tempoExtra;

    public ContratoAluguel(Filme filme, Cliente cliente) {
        super(filme, cliente, false);
        this.devolvido = false;
        this.tempoExtra = 0;
        this.precoFinal = filme.getPreco();
        this.gerarDataDeDevolucao();
    }

    public ContratoAluguel(Filme filme, Cliente cliente, boolean devolvido) {
        this(filme, cliente);
        this.devolvido = devolvido;
    }

    /* Retorna data de devolucao no formato string */
    public String getDataDevolucao() {
        return sdf.format(this.dataDevolucao);
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public int getTempoExtra() {
        return tempoExtra;
    }
    
    /* Sobrescreve método da classe pai
     * Flexibiliza o valor da data de registro, podendo inseri-lo manualmente
     * 
     * @param dataRegistro: Data do registro no tipo Date
    */
    @Override
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
        gerarDataDeDevolucao();
    }

    /* Calcula preço padrão do filme com os adicionais, caso tenha */
    public void gerarPrecoFinal() {
        Filme filme = this.getFilme();
        double valorAdicional = 0;
        
        if (this.tempoExtra != 0) {
            valorAdicional = this.tempoExtra * filme.getPrecoDiaExtra();
        }
        
        this.precoFinal = filme.getPreco() + valorAdicional;
    }

    /* Calcula data de devolução com base na data de registro e tempo de aluguel padrão do filme */
    public final void gerarDataDeDevolucao() {
        int tempoAluguel = this.getFilme().getTempoAluguel();
        
        Calendar c = Calendar.getInstance(); 
        c.setTime(this.dataRegistro); 
        c.add(Calendar.DATE, tempoAluguel);
        this.dataDevolucao = c.getTime();
    }
    
    /* 
    * Adiciona tempo extra na data de devolução do filme e calcula novo valor do contrato

    * @param tempoExtra: Tempo extra em dias
    */
    public void adicionarTempoExtra(int tempoExtra) {
        Calendar c = Calendar.getInstance(); 
        c.setTime(this.dataDevolucao); 
        c.add(Calendar.DATE, tempoExtra);
        this.dataDevolucao = c.getTime();        
        this.tempoExtra = tempoExtra;
        gerarPrecoFinal();        
    }
    
    /* Verifica se a data de devolução é menor do que a data atual
    * e se o filme foi devolvido 
    *
    * @return true: Atrasado / false: Vigente
    */
    public boolean verificarAtrasoAlguel() {
        Date dataAtual = new Date();
        int comparacao = dataAtual.compareTo(dataDevolucao);
        
        return comparacao > 0 && !devolvido;
    } 
    
    /* Imprime detalhes do filme */
    public void exibirDetalhesContratoAluguel() {
        Filme filme = this.getFilme();
        Cliente cliente = this.getCliente();
        
        Saida.linhaTabela(50);
        System.out.print("  ");
        Saida.centralizarValor("DETALHES DO CONTRATO", 50, "||", " ");
        Saida.linhaTabela(50);
        System.out.print("  ");

        Saida.centralizarValor("Filme", 50, "||", " ");
        Saida.pularLinhaTabela(50);
        Saida.exibirAtributoDetalhesObjeto("Nome", filme.getNome());
        Saida.exibirAtributoDetalhesObjeto("Categoria", filme.getCategoria());
        Saida.exibirAtributoDetalhesObjeto("Duração", filme.getDuracao());
        Saida.exibirAtributoDetalhesObjeto("Preço", "R$ " +String.valueOf(filme.getPreco()));
        Saida.exibirAtributoDetalhesObjeto("Taxa dia Adicional", "R$ " + String.valueOf(this.getFilme().getPrecoDiaExtra()));
        Saida.exibirAtributoDetalhesObjeto("Classificação", String.valueOf(filme.getClassificacaoIndicativa()));
        
        Saida.pularLinhaTabela(50);
        System.out.print("\n  ");
        Saida.centralizarValor("Cliente", 50, "||", " ");
        Saida.pularLinhaTabela(50);
        Saida.exibirAtributoDetalhesObjeto("Nome", cliente.getNome());
        Saida.exibirAtributoDetalhesObjeto("CPF", cliente.getCpf());
        Saida.exibirAtributoDetalhesObjeto("Telefone", cliente.getTelefone());

        Saida.pularLinhaTabela(50);
        System.out.print("\n  ");
        Saida.centralizarValor(" CONTRATO ", 50, "||", "-");
        Saida.exibirAtributoDetalhesObjeto("Data de Registro", this.getDataRegistro());
        Saida.exibirAtributoDetalhesObjeto("Data de Devolução", this.getDataDevolucao());
        Saida.exibirAtributoDetalhesObjeto("Tempo Aluguel", String.valueOf(filme.getTempoAluguel()));
        Saida.exibirAtributoDetalhesObjeto("Tempo Adicional", String.valueOf(this.tempoExtra));
        Saida.exibirAtributoDetalhesObjeto("Tempo Total", String.valueOf((this.tempoExtra + filme.getTempoAluguel())));
        Saida.exibirAtributoDetalhesObjeto("Valor Adicional", this.tempoExtra == 0 ? "R$ 0.00" : "R$ "+String.valueOf(tempoExtra * filme.getPrecoDiaExtra()));
        
        Saida.pularLinhaTabela(50);
        Saida.exibirAtributoDetalhesObjeto("Valor Total à pagar", "R$ "+String.valueOf(this.precoFinal));
        Saida.linhaTabela(50);
    }

}
