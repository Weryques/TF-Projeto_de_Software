package principal;

import java.io.*;
import java.util.*;

import niveis.*;
import temas.*;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception, IOException{
		Animais animais = new Animais();
		Filmes filmes = new Filmes();
		Profissoes profissoes = new Profissoes();
		
		Tela tela = new Tela();
		Jogador jogador = new Jogador();
		Controle controle =  new Controle();
		
		Dificil dificil = new Dificil();
		Facil facil = new Facil();
		Medio medio = new Medio();

		char[] copiaTracejada = new char[100];
		char[] erradas = new char[100];

		char letra = 0;
		char[][] forca = new char[10][20];

		int qAcertos = 0, h = 0;
		int nivel = 0, tema = 0, escolha1 = 0;

		nivel = controle.menuNiveis();
		System.out.println();
		escolha1 = controle.menuTemaOuAleatoria();		
		System.out.println();

		if(escolha1 == 1){//vai pegar palavra do tema definido
			tema = controle.menuTema();

			controle.controle(animais, filmes, profissoes, tela, jogador, dificil, facil, medio, copiaTracejada, erradas,
					letra, forca, qAcertos, h, nivel, tema);
		}
		else if(escolha1 == 0){
			controle.controle(animais, filmes, profissoes, tela, jogador, dificil, facil, medio, copiaTracejada, erradas,
					letra, forca, qAcertos, h, nivel, tema);
		}
		else{
			System.out.println("Opção inválida!");
		}
	}
}