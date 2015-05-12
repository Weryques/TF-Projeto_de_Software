package principal;

import java.io.IOException;
import java.util.Scanner;

import temas.Animais;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) throws Exception, IOException{
		Tela tela;
		Animais animais = new Animais();
		
		String palavra = null;
		char[] copiaTracejada = new char[100];
		char[] erradas = new char[100];
		
		char letra;
//		char[][] forca = new char[10][20];
//		
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 20; j++){
//				if(j == 0 && i != 9)
//					forca[i][j] = '|';
//				if((i == 9  && j == 1) || (i == 9 && j == 2))
//					forca[i][j] = '-';
//				if((j == 1 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6 || j == 7 || j == 8 || j == 9 || j == 10) && i == 0)
//					forca[i][j] = '-';
//					
//			}
//		}
//		
//		for(int i = 0; i < 10; i++){
//			for(int j = 0; j < 20; j++)
//				System.out.print(forca[i][j]);
//			System.out.println();
//		}
		
		
		int qAcertos = 0, h = 0, chances = 0;
		
		int nivel = 0, tema = 0, escolha1 = 0;
		
		System.out.println("-----Níveis-----");
		System.out.println("----------------");
		System.out.println("1 - Fácil");
		System.out.println("2 - Médio");
		System.out.println("3 - Dificil");
		System.out.println("----------------");
		System.out.print("Escolha o nível de dificuldade: ");
		nivel = scan.nextInt();
		System.out.println();
		
		System.out.println("Digite 1 (um) para escolher o tema da palavra");
		System.out.println("0 (zero) para adivinhar uma palavra de tema aleatório");
		System.out.print("Escolha: ");
		escolha1 = scan.nextInt();
		System.out.println();
		
		if(escolha1 == 1){
			System.out.println("-----Tema-----");
			System.out.println("---------------");
			System.out.println("1 - Animais");
			System.out.println("2 - Filmes");
			System.out.println("3 - Profissões");
			System.out.println("---------------");
			System.out.println("Escolha o tema da palavra: ");
			tema = scan.nextInt();
			
			if(nivel == 3 && tema == 1){
					chances = 6;
					
					palavra = animais.getPalavraArquivo();
					
					for (int i = 0; i < palavra.length(); i++) {
						if(palavra.charAt(i) != ' ')
							copiaTracejada[i] = '_';
						
					}
					
					while(true){
						int qA = 0;
						
						System.out.println("\n");
						for(int i = 0; i < palavra.length(); i++){
							System.out.print(" "+ copiaTracejada[i] +" ");
						}
						
						System.out.println("\n");
						
						if(erradas != null){
							for(int i = 0; i < erradas.length; i++){
								System.out.print(" "+ erradas[i] +" ");
							}
						}
						
						System.out.println("\n");
						if(qAcertos == palavra.length()){
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
						
						for(int i = 0; i < palavra.length(); i++){
							if(palavra.charAt(i) == letra){
								qAcertos++;
								qA++;
								copiaTracejada[i] = letra;
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
		else if(escolha1 == 0){
			//vai adivinhar uma palavra aleatória do arquivo Animais
		}
		else{
			System.out.println("Opção inválida!");
			System.exit(0);
		}
	}
}