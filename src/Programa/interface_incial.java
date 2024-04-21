package Programa;
import java.util.Scanner;

public class interface_incial {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		boolean sair = true;
		
		while(sair) {
			System.out.println("==========================");
			System.out.println("Menu");
			System.out.println("Selecione uma opção");
			System.out.println("1-Mostrar cotação");
			System.out.println("2-Sair do Menu");
			System.out.println("0-Sair do programa");
			System.out.println("==========================");
			int n = entrada.nextInt();
			
			switch(n) {
			case 1:
				System.out.println("maconha ");
				break;
				
			case 0:
				System.out.println("saindo...");
				System.exit(0);
				break;
				
			case 2:
				System.out.println("saindo do Menu...");
				sair = false;
				break;
			}
		}
	}
}
