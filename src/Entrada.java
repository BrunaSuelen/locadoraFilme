

import java.util.InputMismatchException;
import java.util.Scanner;


public class Entrada {
  
	public static Scanner input = new Scanner(System.in);
	
	/* Recebe entrada de teclado do tipo String */
	public static String recebeString() {
		input = new Scanner(System.in);
		return input.nextLine();
	}
	
	/* Recebe entrada de teclado do tipo inteiro */
	public static int recebeInt() {
            boolean entradaInvalida = true;
            int entrada = 0;
            
            do {
                try {
                    input = new Scanner(System.in);
                    entrada = input.nextInt();
                    entradaInvalida = false;
                } catch(InputMismatchException e) {
                    System.out.print("  ** Entrada inválida, tente novamente: ");
                }
            } while(entradaInvalida);
            
            return entrada;
	}
	
	/* Recebe entrada de teclado do tipo double */
	public static double recebeDouble() {
            boolean entradaInvalida = true;
            double entrada = 0;
            
            do {
                try {
                    input = new Scanner(System.in);
                    entrada = input.nextDouble();
                    entradaInvalida = false;
                } catch(InputMismatchException e) {
                    System.out.print("  ** Entrada inválida, tente novamente: ");
                }
            } while(entradaInvalida);
            
            return entrada;
	}
}
