package principal;

import interfaces.Subject;

import java.util.*;

public class Tela implements Subject{
	static Scanner scan = new Scanner(System.in);
	
	@SuppressWarnings("null")
	public static void main(String[] args){
		char palavra[] = {'B', 'O', 'I'};
		char traced[] = new char[100];
		char erradas[] = new char[100];
		char letra;
		int qAcertos = 0, h = 0, nivel = 0, chances = 0;
		
		for (int i = 0; i < palavra.length; i++) {
			traced[i] = '_';
		}
		
		System.out.println("-----Menu-----");
		System.out.println("---------------");
		System.out.println("1 - Fácil");
		System.out.println("2 - Médio");
		System.out.println("3 - Dificil");
		System.out.println("---------------");
		System.out.println("Escolha: ");
		nivel = scan.nextInt();
		
		
		if(nivel == 3){
			
			chances = 6;
			
			while(true){
				int qA = 0;
				clearConsole();
				
				System.out.println("\n");
				for(int i = 0; i < palavra.length; i++){
					System.out.print(" "+ traced[i] +" ");
				}
				
				System.out.println("\n");
				
				if(erradas != null){
					for(int i = 0; i < erradas.length; i++){
						System.out.print(" "+ erradas[i] +" ");
					}
				}
				
				System.out.println("\n");
				if(qAcertos == palavra.length){
					System.out.println("Você acertou! Parabéns.");
					break;
				}
				else if(chances == 0){
					System.out.println("Você perdeu! Tente novamente!");
					break;
				}
				
				
				System.out.println("\n");
				System.out.print("Digite uma letra: ");
				letra = scan.next().charAt(0);
				
				for(int i = 0; i < palavra.length; i++){
					if(palavra[i] == letra){
						qAcertos++;
						qA++;
						traced[i] = letra;
					}
				}
				
				if(qA == 0){
					erradas[h++] = letra;
					chances--;
					System.out.println("Chances restantes: "+ chances);
				}
			}
		}
	}
	
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	    	e.printStackTrace();
	        //  Handle any exceptions.
	    }
	}

	@Override
	public void adiciona() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifica() {
		// TODO Auto-generated method stub
		
	}
}
