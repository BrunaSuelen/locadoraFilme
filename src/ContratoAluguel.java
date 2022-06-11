import java.util.Calendar;
import java.util.Date;

public class ContratoAluguel extends Contrato {    
    private Date dataDevolucao;
    private boolean devolvido;
    private double precoFinal;
    private int tempoExtra;

    public ContratoAluguel(Filme filme, Cliente cliente, boolean devolvido) {
        super(filme, cliente);
        this.devolvido = devolvido;
        this.tempoExtra = 0;
        this.precoFinal = filme.getPreco();
        this.gerarDataDeDevolucao();
    }
    
    public ContratoAluguel(Filme filme, Cliente cliente) {
        super(filme, cliente);
        this.devolvido = false;
        this.tempoExtra = 0;
        this.precoFinal = filme.getPreco();
        this.gerarDataDeDevolucao();
    }

    public String getDataDevolucao() {
        return sdf.format(this.dataDevolucao);
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
    
    @Override
    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
        gerarDataDeDevolucao();
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    public void gerarPrecoFinal() {
        Filme filme = this.getFilme();
        double valorAdicional = 0;
        
        if (this.tempoExtra != 0) {
            valorAdicional = this.tempoExtra * filme.getPrecoDiaExtra();
        }
        
        this.precoFinal = filme.getPreco() + valorAdicional;
    }

    public int getTempoExtra() {
        return tempoExtra;
    }

    /* Executa um tratamento de erro para a execução do método setDataDevolucao
    * 
    * @param erro: Data que o aluguel foi registrado
    * @return mensagemErro: Descrição do erro apra o usuário
    */
    public final void gerarDataDeDevolucao() {
        int tempoAluguel = this.getFilme().getTempoAluguel();
        
        Calendar c = Calendar.getInstance(); 
        c.setTime(this.dataRegistro); 
        c.add(Calendar.DATE, tempoAluguel);
        this.dataDevolucao = c.getTime();
    }
    
    /* Executa um tratamento de erro para a execução do método setDataDevolucao
    * 
    * @param erro: Data que o aluguel foi registrado
    * @return mensagemErro: Descrição do erro apra o usuário
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
        Saida.exibirAtributoDetalhesObjeto("Preço", String.valueOf(filme.getPreco()));
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
        Saida.exibirAtributoDetalhesObjeto("Tempo Padrão", String.valueOf(filme.getTempoAluguel()));
        Saida.exibirAtributoDetalhesObjeto("Tempo Adicional", String.valueOf(this.tempoExtra));
        Saida.exibirAtributoDetalhesObjeto("Tempo Total", String.valueOf((this.tempoExtra + filme.getTempoAluguel())));
        Saida.exibirAtributoDetalhesObjeto("Valor Adicional", this.tempoExtra == 0 ? "0.00" : String.valueOf(tempoExtra * filme.getPrecoDiaExtra()));
        
        Saida.pularLinhaTabela(50);
        Saida.exibirAtributoDetalhesObjeto("Valor Total à pagar", String.valueOf(this.precoFinal));
        Saida.linhaTabela(50);
    }
}
