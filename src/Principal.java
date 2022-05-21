
import java.util.Scanner;
import classes.Filme;
import java.util.ArrayList;

public class Principal {

  public static void main(String[] args) {
    ArrayList<Filme> locadora = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    int opcao;
    Filme f;

    do {
      System.out.println("Sistema de registro de filmes");
      System.out.println("-------------------------------");
      System.out.println("| 1 - Registrar filme        |");
      System.out.println("| 2 - listar filme(s)        |");
      System.out.println("| 3 - Sair                   |");
      System.out.println("-------------------------------");
      System.out.println("Digite sua opção");
      opcao = scan.nextInt();

      switch (opcao) {

        case 1: {
          f = alugarFilme();
          locadora.add(f);
          break;
        }
        case 2: {
          exibirLista(locadora);
          break;
        }
        case 3: {
          System.out.println("Processo concluído");
          break;
        }
      }
    } while (opcao != 3);

  }

  public static void exibirLista(ArrayList<Filme> locadora) {
    for (int i = 0; i < locadora.size(); i++) {
      locadora.get(i).exibir();
    }
  }

  public static Filme alugarFilme() {
    Scanner scan = new Scanner(System.in);
    Filme f;
    String nom;
    String cat;
    String dur;
    float pre;
    int cla;

    System.out.println("Informe o nome do filme :");
    nom = scan.next();
    System.out.println("Informe a categoria do filme :");
    cat = scan.next();
    System.out.println("Informe a duração do filme :");
    dur = scan.next();
    System.out.println("Informe o preço do filme :");
    pre = scan.nextFloat();
    System.out.println("Informe a classificação indicaitva do filme :");
    cla = scan.nextInt();

    f = new Filme(nom, cat, dur, pre, cla);
    return f;

  }

}