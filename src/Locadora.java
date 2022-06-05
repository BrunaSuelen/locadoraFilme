import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Locadora {

    public ArrayList<Filme> filmes;
    public ArrayList<Contrato> contratos;

    public Locadora() {
        this.contratos = new ArrayList<>();
        this.filmes = new ArrayList<>();
        this.gerarFilmes();
    }

    /* Cadastra automáticamente 8 objetos para a classe filme */
    public final void gerarFilmes() {
        filmes.add(new Filme("Alita","Ação","2:30",14, 12));
        filmes.add(new Filme("Gente Grande","Comedia","2:00",10, 12));
        filmes.add(new Filme("Invocação do mal","Terror","1:30",18, 12));
        filmes.add(new Filme("Barraca do beijo","Romance","2:56",14, 12));
        filmes.add(new Filme("Pânico","Suspense","2:05",18, 12));
        filmes.add(new Filme("A cabana","Drama","1:50",16, 12));
        filmes.add(new Filme("Missão Impossível","Ação","2:10",12, 12));
        filmes.add(new Filme("Homem Aranha","Ação","2:10",12, 12));
    }
        
    /* Adiciona o filme enviado ao arrayList de filmes 
    * 
    * @param filme: Objeto filme já instânciado*/
    public void cadastrarFilme(Filme filme) {
        this.filmes.add(filme);
    }
    
    /* Imprime uma tabela de filmes previamente cadastrados
     * 
     *  @param filmes*/
    public void listarFilmes() {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome   \t\t\t\t|   Preço   |  Locado  ||");
        Saida.linhaTabela(68);

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
        Saida.exibirBotoesDeAcao();
    }

    /* Imprime uma tabela de contratos previamente cadastrados
    * 
    *  @param contratos*/
    public void listarContratosAluguel() {
        //Imprime o cabeçalho da tabela
        System.out.print("\n  || Cod. | Nome Cliente   \t\t|   Locação em   |  Devolução em  ||");
        Saida.linhaTabela(70);

        if (contratos.isEmpty()) {
            Saida.centralizarValor("Nenhum recibo encontrado", 68, "  ||", " ");

        } else {
            //Preenche linha da tabela com os atributos do contrato
//            for (int i = 0; i < contratos.size(); i++) {
//                Contrato contrato = contratos.get(i);
//                System.out.print("  || " + i);
//                Saida.preencheEspacoFaltante(5, String.valueOf(i), " ");
//
//                System.out.print("| " + contrato.getCliente());
//                Saida.preencheEspacoFaltante(28, contratos.get(i).getCliente(), " ");
//
//                System.out.print("| " + contrato.getDataLocacao());
//                Saida.preencheEspacoFaltante(15, String.valueOf(contrato.getDataLocacao()), " ");
//
//                System.out.print("| " + contrato.getDataDevolucao());
//                Saida.preencheEspacoFaltante(15, String.valueOf(contrato.getDataDevolucao()), " ");
//
//                System.out.print("||");
//            }
        }

        Saida.linhaTabela(70);
        Saida.exibirBotoesDeAcao();
    }

    public void listarAlugueisAtrasados() {
        
    }
    
    /* Realiza o processo de aluguel do filme.
    * Adicionado o contrato enviado ao arrayList de contratos e altera status de aluguel do filme
    * 
    * @param contrato: Objeto contrato já instânciado
    * @param idFilme: Indice de posicionamento do filme no arrayList*/
    public void alugarFilme(Contrato contrato, int idFilme) {
        this.filmes.get(idFilme).setAlugado(true);
        this.contratos.add(contrato);
    }

    /* Busca dentro do arrayList de filmes o objeto que possui o mesmo nome passado pelo parâmetro 
    * 
    * @param nomeFilme: Nome do filme que deseja encontrar
    * @return Indice que o filme está posicionado*/
    public int buscarFilme(String nomeFilme) {
        for (int i = 0; i < this.filmes.size(); i++) {
            if (this.filmes.get(i).getNome().equals(nomeFilme)) {
                return i;
            }
        }

        return -1;
    }
}
