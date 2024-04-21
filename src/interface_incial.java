import java.util.Scanner;

public class interface_incial {
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		boolean sair = true;
		
		while(sair) {
			System.out.println("Menu");
			System.out.println("Selecione uma opção");
			System.out.println("Mostrar cotação");
			int n = entrada.nextInt();
			
			switch(n) {
			case 1:
				System.out.println("maconha");
				
			case 0:
				
				System.exit(0);
			case 2:
				sair = false;
			}
		}
		
	}
	
}
