package principal;

import java.util.Scanner;

import niveis.Dificil;
import temas.Animais;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args){
		Dificil nivel3;
		Animais tema1;
		Tela tela;
		
		int nivel, tema, escolha1;
		
		System.out.println("-----Níveis-----");
		System.out.println("----------------");
		System.out.println("1 - Fácil");
		System.out.println("2 - Médio");
		System.out.println("3 - Dificil");
		System.out.println("----------------");
		System.out.print("Escolha o nível de dificuldade: ");
		nivel = scan.nextInt();
		
		
		System.out.println("Digite 1 (um) para escolher o tema da palavra");
		System.out.println("0 (zero) para adivinhar uma palavra de tema aleatório");
		System.out.print("Escolha: ");
		escolha1 = scan.nextInt();
		
		if(escolha1 == 1){
			System.out.println("-----Tema-----");
			System.out.println("---------------");
			System.out.println("1 - Animais");
			System.out.println("2 - Filmes");
			System.out.println("3 - Profissões");
			System.out.println("---------------");
			System.out.println("Escolha o tema da palavra: ");
			nivel = scan.nextInt();
		}
		else if(escolha1 == 0){
			//vai adivinhar uma palavra aleatória
		}
		else{
			System.out.println("Opção inválida!");
			System.exit(0);
		}
	}
}


/*public static void main(String[] args){
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
}*/