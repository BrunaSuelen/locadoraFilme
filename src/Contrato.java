
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {

    private Filme filme;
    private Cliente cliente;
    protected Date dataRegistro;
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

    public String getDataRegistro() {
        return sdf.format(this.dataRegistro.toString());
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
    
    public void exibirContratoParaTabela(int codContrato) {
        System.out.print("  || " + codContrato);
        Saida.preencheEspacoFaltante(5, String.valueOf(codContrato), " ");

        System.out.print("| " + this.cliente.getNome());
        Saida.preencheEspacoFaltante(28, this.cliente.getNome(), " ");

        System.out.print("| " + this.cliente.getCpf());
        Saida.preencheEspacoFaltante(15, this.cliente.getCpf(), " ");

        System.out.print("| " + this.filme.getNome());
        Saida.preencheEspacoFaltante(15,  this.filme.getNome(), " ");
        
        System.out.print("| " + this.getDataRegistro());
        Saida.preencheEspacoFaltante(15, this.getDataRegistro(), " ");
    }

    protected Date converteStringParaData(String dataDevolucao) {        
        try {
            return sdf.parse(dataDevolucao);
            
        } catch(ParseException e) {
            return null;
        }
    }
}
