
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ContratoAluguel extends Contrato {    
    private Date dataDevolucao;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ContratoAluguel(Filme filme, Cliente cliente) {
        super(filme, cliente);
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
        
        if (dataFormatada == null) {
            return 1;
        }
        
        if (this.verificarDataDeDevolucao(dataFormatada)) {
            return 2;
        }
        
        this.dataDevolucao = dataFormatada;
        return 0;
    }
    
    private Date converteStringParaData(String dataDevolucao) {        
        try {
            return sdf.parse(dataDevolucao);
            
        } catch(ParseException e) {
            System.out.print(e);
            return null;
        }
    }
        
    /* Verifica se a data de devolucao é menor que a data de aluguel;
    * 
    * @param dataAluguel: Data que o aluguel foi registrado
    * @param dataDevolucao: Data prevista para devolução do filme
    * @return 0: Data igual / 1: Devolucão ma
    */
    private boolean verificarDataDeDevolucao(Date dataDevolucao) {
        int comparacao = dataRegistro.compareTo(dataDevolucao);
        
        return comparacao != 1;        
    }
}
