package principal;

import java.io.*;
import java.util.*;

import observadores.*;
import niveis.*;
import temas.*;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception, IOException{
		Animais animais = new Animais();
		Filmes filmes = new Filmes();
		Profissoes profissoes = new Profissoes();
		
		Tela tela = new Tela();
		
		FimJogo fimJogo = new FimJogo();
		BancoLetrasErradas bancoLetras = new BancoLetrasErradas();
		Forca forcaI = new Forca();
		PalavraAnonima palavraAnonima = new PalavraAnonima();
		
		Controle ctrl =  new Controle();
		
		Dificil dificil = new Dificil();
		Facil facil = new Facil();
		Medio medio = new Medio();

		int nivel = 0, tema = 0, escolha1 = 0;

		nivel = ctrl.menuNiveis();
		System.out.println();
		escolha1 = ctrl.menuTemaOuAleatoria();		
		System.out.println();
		
		ctrl.limparConsole();
		
		if(escolha1 == 1){//vai pegar palavra do tema definido
			tema = ctrl.menuTema();
			
			ctrl.limparConsole();
			
			ctrl.controle(animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, nivel, tema);
			
		}
		else if(escolha1 == 0){
			ctrl.limparConsole();
			
			ctrl.controle(animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, nivel, tema);
			
		}
		else{
			ctrl.limparConsole();
			System.out.println("Opção inválida!");
		}
	}
}