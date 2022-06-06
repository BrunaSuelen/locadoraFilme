import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


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

    /* Cadastra automáticamente 8 objetos para a classe cliente */
    public final void gerarDados() {
        Filme filme1 = new Filme("Alita","Ação","2:30",14, 12, true);
        Filme filme2 = new Filme("Gente Grande","Comedia","2:00",10, 12, true);
        
        Cliente cliente1 = new Cliente("Rogério","789.789.879-87","98845-4545");
        Cliente cliente2 = new Cliente("Beatriz","545.022.112-01","98475-9874");
        
        ContratoAluguel contratoAluguel1 = new ContratoAluguel(filme1, cliente1, false);
        contratoAluguel1.setDataRegistro(contratoAluguel1.converteStringParaData("01/06/2022"));
        contratoAluguel1.setDataDevolucao("05/06/2022");
        
        ContratoAluguel contratoAluguel2 = new ContratoAluguel(filme2, cliente2, true);
        contratoAluguel2.setDataRegistro(contratoAluguel1.converteStringParaData("12/05/2022"));
        contratoAluguel1.setDataDevolucao("14/05/2022");
        
        
        filmes.add(filme1);
        filmes.add(filme2);
        filmes.add(new Filme("Barraca do beijo","Romance","2:56",14, 12));
        filmes.add(new Filme("Invocação do mal","Terror","1:30",18, 12));
        filmes.add(new Filme("Pânico","Suspense","2:05",18, 12));
        filmes.add(new Filme("A cabana","Drama","1:50",16, 12));
        filmes.add(new Filme("Missão Impossível","Ação","2:10",12, 12));
        filmes.add(new Filme("Homem Aranha","Ação","2:10",12, 12));
        
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
        System.out.print("\n  || Cod. | Nome   \t\t\t\t|   Preço   |  Locado  ||");
        Saida.linhaTabela(68);
        
        if (filmes == null) {
            filmes = this.filmes;
        }

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
        
        Saida.linhaTabela(68);
    }

    public void listarContratosAluguel(boolean exibirApenasAtrasados) {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome Cliente \t| CPF       | Filme \t| Registrado em | Devolução em |  Status  ||");
        Saida.linhaTabela(80);
        
        ArrayList<ContratoAluguel> contratos = exibirApenasAtrasados ? buscarAlugueisAtrasados() : contratosAluguel;
        for (int i = 0; i < contratos.size(); i++) {
            ContratoAluguel contrato = contratos.get(i);
            contrato.exibirContratoParaTabela(i);
        
            System.out.print("| " + contrato.getDataDevolucao());
            Saida.preencheEspacoFaltante(15, contrato.getDataDevolucao(), " ");
            
            String status = contrato.verificarAtrasoAlguel() ? "Atrasado" : "Em dia";
            System.out.print("||");
        }

        Saida.linhaTabela(80);
        Saida.exibirBotoesDeAcao();
    }
    
    public void listarContratosVenda() {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome Cliente \t| CPF       | Filme \t| Registrado em ||");
        Saida.linhaTabela(80);
        
        for (int i = 0; i < contratosVenda.size(); i++) {
            Contrato contrato = contratosVenda.get(i);
            contrato.exibirContratoParaTabela(i);
            
            System.out.print("||");
        }

        Saida.linhaTabela(80);
        Saida.exibirBotoesDeAcao();
    }
    
    /* Imprime uma tabela de clientes previamente cadastrados */
    public void listarClientes(boolean exibirBotaoNovo) {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome   \t\t\t|     CPF     |     Telefone     ||");
        Saida.linhaTabela(68);
        
        if (exibirBotaoNovo) {
            System.out.print("  || 0");
            Saida.preencheEspacoFaltante(5, "0", " ");

            System.out.print("| NOVO CLIENTE");
            Saida.preencheEspacoFaltante(60, "NOVO CLIENTE", " ");
            System.out.print("||");
            Saida.linhaTabela(68);
        }

        if (clientes.isEmpty()) {
            Saida.centralizarValor("Nenhum contrato encontrado", 66, "  ||", " ");
        } else {
            //Preenche linha da tabela com os atributos do cliente
            for (int i = 0; i < clientes.size(); i++) {
                Cliente cliente = clientes.get(i);
                System.out.print("  || " + (i+1));
                Saida.preencheEspacoFaltante(5, String.valueOf(i), " ");

                System.out.print("| " + cliente.getNome());
                Saida.preencheEspacoFaltante(27, cliente.getNome(), " ");

                System.out.print("| " + cliente.getCpf());
                Saida.preencheEspacoFaltante(12, cliente.getCpf(), " ");

                System.out.print("| " + cliente.getTelefone());
                Saida.preencheEspacoFaltante(17, cliente.getTelefone(), " ");
                System.out.println("||");
            }
        }
        
        Saida.linhaTabela(68);
    }
        
    /* Realiza o processo de aluguel do cliente.
    * Adicionado o contrato enviado ao arrayList de contratosAluguel e altera status de aluguel do cliente
    * 
    * @param contrato: Objeto contrato já instânciado
    * @param idFilme: Indice de posicionamento do cliente no arrayList*/
    public void alugarFilme(ContratoAluguel contrato, int idFilme) {
        this.filmes.get(idFilme).setAlugado(true);
        this.contratosAluguel.add(contrato);
    }
    
     /* Realiza o processo de aluguel do cliente.
    * Adicionado o contrato enviado ao arrayList de contratosAluguel e altera status de aluguel do cliente
    * 
    * @param contrato: Objeto contrato já instânciado
    * @param idFilme: Indice de posicionamento do cliente no arrayList*/
    public void venderFilme(Contrato contrato, int idFilme) {
        this.contratosVenda.add(contrato);
        this.filmes.remove(idFilme);
    }

    /* Busca dentro do arrayList de filmes o objeto que possui o mesmo nome passado pelo parâmetro 
    * 
    * @param nomeFilme: Nome do cliente que deseja encontrar
    * @return Indice que o cliente está posicionado*/
    public ArrayList<Filme> buscarFilme(String nomeFilme) {
        ArrayList<Filme> filmesEncontrados = new ArrayList<>();
        
        for (int i = 0; i < this.filmes.size(); i++) {
            String nomeFilmeInformado = nomeFilme.toUpperCase();
            String nomeFilmeAtual = this.filmes.get(i).getNome().toUpperCase();
            
            if (nomeFilmeAtual.indexOf(nomeFilmeInformado) != -1) {
                filmesEncontrados.add(this.filmes.get(i));
            }
        }

        return filmesEncontrados;
    }

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
}
