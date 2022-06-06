
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContratoAluguel extends Contrato {    
    private Date dataDevolucao;

    public ContratoAluguel(Filme filme, Cliente cliente) {
        super(filme, cliente);
        sdf.setLenient(false);
    }

    public String getDataDevolucao() {
        return sdf.format(this.dataDevolucao.toString());
    }

    /* Verifica se a data de devolucao é menor que a data de aluguel;
    * 
    * @param dataAluguel: Data que o aluguel foi registrado
    * @param dataDevolucao: Data prevista para devolução do filme
    * @return 0: Data válida / 1: Formato inválido / 2: Data inválida
    */
    public int setDataDevolucao(String dataDevolucao) {        
        Date dataFormatada = this.converteStringParaData(dataDevolucao);
        this.dataDevolucao = dataFormatada;
        
        if (dataFormatada == null) {
            return 1;
        }
        
        if (this.verificarDataDeDevolucao()) {
            return 2;
        }
        
        return 0;
    }
            
    /* Verifica se a data de devolucao é menor que a data de aluguel;
    * 
    * @param dataAluguel: Data que o aluguel foi registrado
    * @param dataDevolucao: Data prevista para devolução do filme
    * @return 0: Data igual / 1: Devolucão ma
    */
    public boolean verificarDataDeDevolucao() {
        int comparacao = dataDevolucao.compareTo(dataRegistro);
        
        return comparacao != 1;        
    }
    
    public boolean verificarAtrasoAlguel() {
        Date dataAtual = new Date();
        int comparacao = dataAtual.compareTo(dataDevolucao);
        
        return comparacao > 0;
    } 
    
    /* Verifica se a data de devolucao é menor que a data de aluguel;
    * 
    * @param dataAluguel: Data que o aluguel foi registrado
    * @param dataDevolucao: Data prevista para devolução do filme
    * @return 0: Data igual / 1: Devolucão ma
    */
    public String mensagemErroValidacaoDataDevolucao(int erro) {                
        switch(erro) {
            case 1: return "Formato de data inválido";
            case 2: return "A data de devolução não pode ser inferior à data do aluguel";
        }
        
        return "";
    }
}
