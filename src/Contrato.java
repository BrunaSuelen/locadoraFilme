
import java.util.Date;

public class Contrato {

    private Filme filme;
    private Cliente cliente;
    protected Date dataRegistro;

    public Contrato(Filme filme, Cliente cliente) {
        this.filme = filme;
        this.cliente = cliente;
        this.setDataRegistro();
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

    public Date getDataRegistro() {
        return dataRegistro;
    }

    private void setDataRegistro() {
        this.dataRegistro = new Date();
    }
}
