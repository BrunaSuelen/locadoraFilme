package uteis;

import java.util.Scanner;


public class Entrada {
  
	public static Scanner input = new Scanner(System.in);
	
	public static String recebeString() {
		input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static int recebeInt() {
		return input.nextInt();
	}
	
	public static double recebeDouble() {
		return input.nextDouble();
	}
}
