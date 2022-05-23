package uteis;

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
		return input.nextInt();
	}
	
	/* Recebe entrada de teclado do tipo double */
	public static double recebeDouble() {
		return input.nextDouble();
	}
}
