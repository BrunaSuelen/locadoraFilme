import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ContratoAluguel extends Contrato {    
    private Date dataDevolucao;
    private boolean devolvido;

    public ContratoAluguel(Filme filme, Cliente cliente, boolean devolvido) {
        super(filme, cliente);
        this.devolvido = devolvido;
    }
    
    public ContratoAluguel(Filme filme, Cliente cliente) {
        super(filme, cliente);
        this.devolvido = false;
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

    /* Armazena e verifica se a data de devolucao é válida
    * 
    * @param dataDevolucao: Data prevista para devolução do filme
    * @return 0: Data válida / 1: Formato inválido / 2: Data inválida
    */
    public int setDataDevolucao(String dataDevolucao) {        
//        Date dataFormatada = this.converteStringParaData(dataDevolucao);
//        boolean dataFormatadaCorretamente = sdf.format(dataFormatada).equals(dataDevolucao);
//        this.dataDevolucao = dataFormatada;
//        
//        if (dataFormatada == null || !dataFormatadaCorretamente) {
//            return 1;
//        }
//        
//        if (this.verificarDataDeDevolucao()) {
//            return 2;
//        }
        verificaTempoMaxContrato();
        return 0;
    }
    
    /* Verifica se a data de devolucao é menor que a data de aluguel
    * 
    * @return < 0: Data menor / 0: Data igual / 1: Data maior
    */
    public boolean verificarDataDeDevolucao() {
        int comparacao = dataDevolucao.compareTo(dataRegistro);
        
        return comparacao != 1;        
    }
    
    /* Executa um tratamento de erro para a execução do método setDataDevolucao
    * 
    * @param erro: Data que o aluguel foi registrado
    * @return mensagemErro: Descrição do erro apra o usuário
    */
    public String verificaTempoMaxContrato() {
        //long diff = this.dataRegistro.getTime() - this.dataDevolucao.getTime();
        System.out.println(this.dataRegistro.getTime());

//        TimeUnit time = TimeUnit.DAYS; 
//        long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
//        System.out.println("The difference in days is : "+diffrence);
        
        return "";
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
    
    /* Executa um tratamento de erro para a execução do método setDataDevolucao
    * 
    * @param erro: Data que o aluguel foi registrado
    * @return mensagemErro: Descrição do erro apra o usuário
    */
    public String mensagemErroValidacaoDataDevolucao(int erro) {                
        switch(erro) {
            case 1: return "Formato de data inválido";
            case 2: return "A data de devolução não pode ser inferior à data do aluguel";
        }
        
        return "";
    }
}
