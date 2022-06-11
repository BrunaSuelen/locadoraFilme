public class Cliente {
    
    private String nome, cpf, telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Cliente(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String validarCPF(String cpf) {
        return cpf.length() != 14 ? null : cpf;
    }
    
    public String validarTelefone(String telefone) {
        return telefone.length()!= 13 ? null : telefone;
    }    
}
