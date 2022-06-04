

import java.util.ArrayList;
import classes.Filme;


public class Rotina {
	/* Cadastra automáticamente 8 objetos para a classe filme */
	public static ArrayList<Filme> gerarFilmes() {
            ArrayList<Filme> filmes = new ArrayList<Filme>();	
            filmes.add(new Filme("Alita","Ação","2:30",14, 12));
            filmes.add(new Filme("Gente Grande","Comedia","2:00",10, 12));
            filmes.add(new Filme("Invocação do mal","Terror","1:30",18, 12));
            filmes.add(new Filme("Barraca do beijo","Romance","2:56",14, 12));
            filmes.add(new Filme("Pânico","Suspense","2:05",18, 12));
            filmes.add(new Filme("A cabana","Drama","1:50",16, 12));
            filmes.add(new Filme("Missão Impossível","Ação","2:10",12, 12));
            filmes.add(new Filme("Homem Aranha","Ação","2:10",12, 12));
            return filmes;
	}
}
