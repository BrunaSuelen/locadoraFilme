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
    
    /* Valida o cpf informado com base no tamanho da string
     * 
     * @param cpf: Valor do cpf em string
     * @return cpf / null: caso o cpf seja inválido
     */
    public String validarCPF(String cpf) {
        return cpf.length() != 14 ? null : cpf;
    }
    
    /*
     * Valida o telefone informado com base no tamanho da string
     * 
     * @param telefone: Valor do telefone em string  
     * @return telefone / null: caso o telefone seja inválido
     */
    public String validarTelefone(String telefone) {
        return telefone.length()!= 13 ? null : telefone;
    }    
}
