
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {

    private Filme filme;
    private Cliente cliente;
    protected Date dataRegistro;
    protected double precoFinal;
    protected SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Contrato(Filme filme, Cliente cliente) {
        this.filme = filme;
        this.cliente = cliente;
        this.dataRegistro = new Date();
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /* Retorna data de registro no formato string */
    public String getDataRegistro() {
        return sdf.format(this.dataRegistro);
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }
    
    /* Imprime dados do contrato para preenchimento de tabela */
    public void exibirContratoParaTabela(int codContrato) {
        System.out.print("  || " + codContrato);
        Saida.preencheEspacoFaltante(5, String.valueOf(codContrato), " ");

        System.out.print("| " + this.cliente.getNome());
        Saida.preencheEspacoFaltante(19, this.cliente.getNome(), " ");

        System.out.print("| " + this.cliente.getCpf());
        Saida.preencheEspacoFaltante(15, this.cliente.getCpf(), " ");

        System.out.print("| " + this.filme.getNome());
        Saida.preencheEspacoFaltante(15,  this.filme.getNome(), " ");
        
        System.out.print("| " + this.getDataRegistro());
        Saida.preencheEspacoFaltante(16, this.getDataRegistro(), " ");
    }

    /* Converte a data de String para o formato Date
    * 
    * @param dataDevolucao: Data no formato String
    * @return Mesma data, porém em formato Date*/
    protected Date converteStringParaData(String dataDevolucao) {        
        try {
            return sdf.parse(dataDevolucao);
            
        } catch(ParseException e) {
            return null;
        }
    }
}
