import java.util.ArrayList;


public class Locadora {

    public ArrayList<Filme> filmes;
    public ArrayList<Cliente> clientes;
    public ArrayList<Contrato> contratosVenda;
    public ArrayList<ContratoAluguel> contratosAluguel;

    public Locadora() {
        this.contratosVenda = new ArrayList<>();
        this.contratosAluguel = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.filmes = new ArrayList<>();
        this.gerarDados();
    }

    /* Cadastra automáticamente alguns objetos */
    public final void gerarDados() {
        Filme filme1 = new Filme("Alita","Ação","2:30",5.00, 1.20, 12, true, 2);
        Filme filme2 = new Filme("Gente Grande","Comedia","2:00",4.50, 1.00, 12, true, 3);
        
        Cliente cliente1 = new Cliente("Rogério","789.789.879-87","98845-4545");
        Cliente cliente2 = new Cliente("Beatriz","545.022.112-01","98475-9874");
        
        ContratoAluguel contratoAluguel1 = new ContratoAluguel(filme1, cliente1, false);
        contratoAluguel1.setDataRegistro(contratoAluguel1.converteStringParaData("01/06/2022"));
        
        ContratoAluguel contratoAluguel2 = new ContratoAluguel(filme2, cliente2, false);
        contratoAluguel2.setDataRegistro(contratoAluguel1.converteStringParaData("12/05/2022"));
        
        
        filmes.add(filme1);
        filmes.add(new Filme("Barraca do beijo","Romance","2:56",6.00, 2.00, 12, 2));
        filmes.add(new Filme("Invocacao do mal","Terror","1:30",4.50, 1.00, 12, 3));
        filmes.add(new Filme("Panico","Suspense","2:05",5.00, 1.20, 12, 3));
        filmes.add(new Filme("A cabana","Drama","1:50",4.00, 1.50, 12, 4));
        filmes.add(new Filme("Missao Impossivel","Ação","2:10",5.00, 1.50, 12, 5));
        filmes.add(filme2);
        filmes.add(new Filme("Homem Aranha","Ação","2:10",20, 8.00, 3, 2));
        
        clientes.add(cliente1);
        clientes.add(cliente2);
        
        contratosAluguel.add(contratoAluguel1);
        contratosAluguel.add(contratoAluguel2);
    }
        
    /* Adiciona o filme enviado ao arrayList de filmes 
    * 
    * @param filme: Objeto filme já instânciado*/
    public void cadastrarFilme(Filme filme) {
        this.filmes.add(filme);
    }
       
    /* Adiciona o cliente enviado ao arrayList de cliente 
    * 
    * @param cliente: Objeto cliente já instânciado*/
    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    /* Imprime uma tabela de filmes previamente cadastrados */
    public void listarFilmes(ArrayList<Filme> filmes) {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome   \t\t\t\t|   Preço   |  Alugado  ||");
        Saida.linhaTabela(68);
        
        if (filmes == null) {
            filmes = this.filmes;
        }

        if (filmes.isEmpty()) {
            Saida.centralizarValor("Nenhum filme encontrado", 80, "  ||", " ");
        } else {
            //Preenche linha da tabela com os atributos do filme
            for (int i = 0; i < filmes.size(); i++) {
                Filme filme = filmes.get(i);
                System.out.print("  || " + i);
                Saida.preencheEspacoFaltante(5, String.valueOf(i), " ");

                System.out.print("| " + filme.getNome());
                Saida.preencheEspacoFaltante(36, filme.getNome(), " ");

                System.out.print("| " + filme.getPreco());
                Saida.preencheEspacoFaltante(10, String.valueOf(filme.getPreco()), " ");

                String statusAlugado = filme.getAlugado() ? "Sim" : "Não";
                System.out.print("| " + statusAlugado);
                Saida.preencheEspacoFaltante(10, statusAlugado, " ");
                System.out.println("||");
            }
        }
        
        Saida.linhaTabela(68);
    }

    /* Imprime uma tabela de contratos de alguel previamente cadastrados */
    public void listarContratosAluguel(ArrayList<ContratoAluguel> contratos) {
        //Imprime o cabeçalho da tabela
        Saida.linhaTabela(119);
        System.out.print("  || Cod. | Cliente \t\t| CPF  \t");
        System.out.print("\t | Filme \t   | Registrado em   | Devolução em   | Devolvido |  Status  ||");
        Saida.linhaTabela(119);
        
        if (contratos.isEmpty()) {
            Saida.centralizarValor("Nenhum filme encontrado", 117, "  ||", " ");
        } else {
            //Preenche linha da tabela com os atributos do filme
            for (int i = 0; i < contratos.size(); i++) {
                ContratoAluguel contrato = contratos.get(i);
                contrato.exibirContratoParaTabela(i);

                System.out.print("| " + contrato.getDataDevolucao());
                Saida.preencheEspacoFaltante(16, contrato.getDataDevolucao(), " ");

                String devolvido = contrato.isDevolvido() ? "Sim" : "Não";
                System.out.print("| " + devolvido);
                Saida.preencheEspacoFaltante(8, devolvido, " ");

                String status = contrato.verificarAtrasoAlguel() ? "Atrasado" : "Em dia";
                System.out.print("| " + status);
                Saida.preencheEspacoFaltante(10, status, " ");  
                System.out.println("||");
            }
        }

        Saida.linhaTabela(119);
    }
    
    /* Imprime uma tabela de contratos de venda previamente cadastrados */
    public void listarContratosVenda() {
        //Imprime o cabeçalho da tabela
        Saida.linhaTabela(80);
        System.out.print("  || Cod. | Nome Cliente \t| CPF \t\t | Filme     \t   | Registrado em    ||");
        Saida.linhaTabela(80);
        
        if (contratosVenda.isEmpty()) {
            Saida.centralizarValor("Nenhum contrato encontrado", 78, "  ||", " ");
        } else {
             for (int i = 0; i < contratosVenda.size(); i++) {
                Contrato contrato = contratosVenda.get(i);
                contrato.exibirContratoParaTabela(i);

                System.out.print("||");
            }
        }
        
        Saida.linhaTabela(80);
        Saida.exibirBotoesDeAcao();
    }
    
    /* Imprime uma tabela de clientes previamente cadastrados 
    *
    * @params exibirBotaoNovo: Valor booleano que indica se deve exibir opção de novo cliente ou não*/
    public void listarClientes(boolean exibirBotaoNovo) {
        //Imprime o cabeçalho da tabela
        Saida.linhaTabela(72);
        System.out.print("  || Cod. | Nome   \t\t\t| CPF \t\t  |     Telefone     ||");
        Saida.linhaTabela(72);
        
        if (exibirBotaoNovo) {
            System.out.print("  || 0");
            Saida.preencheEspacoFaltante(5, "0", " ");

            System.out.print("| NOVO CLIENTE");
            Saida.preencheEspacoFaltante(64, "NOVO CLIENTE", " ");
            System.out.print("||");
            Saida.linhaTabela(72);
        }

        if (clientes.isEmpty()) {
            Saida.centralizarValor("Nenhum contrato encontrado", 80, "  ||", " ");
        } else {
            //Preenche linha da tabela com os atributos do cliente
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                System.out.print("  || " + (i+1));
                Saida.preencheEspacoFaltante(5, String.valueOf(i), " ");

                System.out.print("| " + cliente.getNome());
                Saida.preencheEspacoFaltante(27, cliente.getNome(), " ");

                System.out.print("| " + cliente.getCpf());
                Saida.preencheEspacoFaltante(15, cliente.getCpf(), " ");

                System.out.print("| " + cliente.getTelefone());
                Saida.preencheEspacoFaltante(18, cliente.getTelefone(), " ");
                System.out.println("||");
            }
        }
        
        Saida.linhaTabela(72);
    }
        
    /* Realiza o processo de aluguel do filme.
    * Adicionado o contrato enviado ao arrayList de contratosAluguel e altera status de aluguel do filme
    * 
    * @param contrato: Objeto contrato já instânciado
    * @param idFilme: Indice de posicionamento do filme no arrayList*/
    public void alugarFilme(ContratoAluguel contrato, int idFilme) {
        this.filmes.get(idFilme).setAlugado(true);
        this.contratosAluguel.add(contrato);
    }
    
    /* Realiza o processo de venda do filme.
    * Adicionado o contrato enviado ao arrayList de contratosVenda e remove o filme da lista de filmes da locadora
    * 
    * @param contrato: Objeto contrato já instânciado
    * @param idFilme: Indice de posicionamento do filme no arrayList*/
    public void venderFilme(Contrato contrato, int idFilme) {
        this.contratosVenda.add(contrato);
        this.filmes.remove(idFilme);
    }

    /* Busca dentro do arrayList de filmes o objeto que possui o mesmo nome passado pelo parâmetro 
    * 
    * @param nomeFilme: Nome do filme que deseja encontrar
    * @return Lista de filmes encontrado com a partir do nome informado pelo cliente*/
    public ArrayList<Filme> buscarFilme(String nomeFilme) {
        ArrayList<Filme> filmesEncontrados = new ArrayList<>();
        
        if (nomeFilme.equals("")) {
            return this.filmes;
        }
        
        for (int i = 0; i < this.filmes.size(); i++) {
            String nomeFilmeInformado = nomeFilme.toUpperCase();
            String nomeFilmeAtual = this.filmes.get(i).getNome().toUpperCase();
            
            if (nomeFilmeAtual.indexOf(nomeFilmeInformado) != -1) {
                filmesEncontrados.add(this.filmes.get(i));
            }
        }

        return filmesEncontrados;
    }

    /* Busca dentro do arrayList de contratos de aluguel filmes em atraso
    * 
    * @return Lista de contratos atrasados*/
    public ArrayList<ContratoAluguel> buscarAlugueisAtrasados() {
        ArrayList<ContratoAluguel> alugueisAtrasados = new ArrayList<>();
        
        for (int i = 0; i < contratosAluguel.size(); i++) {
            ContratoAluguel contrato = contratosAluguel.get(i);
            if (contrato.verificarAtrasoAlguel()) {
                alugueisAtrasados.add(contrato);
            }
        }
        
        return alugueisAtrasados;
    }
    
    /* Busca dentro do arrayList de contratos de aluguel vigentes
    * 
    * @return Lista de contratos vigentes*/
    public ArrayList<ContratoAluguel> buscarAlugueisVigentes() {
        ArrayList<ContratoAluguel> alugueisAtrasados = new ArrayList<>();
        
        for (int i = 0; i < contratosAluguel.size(); i++) {
            ContratoAluguel contrato = contratosAluguel.get(i);
            if (!contrato.isDevolvido()) {
                alugueisAtrasados.add(contrato);
            }
        }
        
        return alugueisAtrasados;
    }
    
    /* Registra no contrato de devolução o status de devolvido
    *  Altera o status de alugado do filme vinculado
    *
    * @return codContrato: Indice que o contrato se encontra no array de locadora*/
    public void registrarDevolucaoFilme(int codContrato) {
        contratosAluguel.get(codContrato).setDevolvido(true);
        contratosAluguel.get(codContrato).getFilme().setAlugado(false);        
    }
}
