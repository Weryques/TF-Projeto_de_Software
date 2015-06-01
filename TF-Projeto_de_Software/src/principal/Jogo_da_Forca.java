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

		TelaObservavel tela = new TelaObservavel();

		FimJogo fimJogo = new FimJogo();
		BancoLetrasErradas bancoLetras = new BancoLetrasErradas();
		Forca forcaI = new Forca();
		PalavraAnonima palavraAnonima = new PalavraAnonima();

		Dificil dificil = new Dificil();
		Facil facil = new Facil();
		Medio medio = new Medio();
		Visao visao = new Visao();
		
		Controle ctrl = new Controle(visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio);
		ctrl.controle();

	}
}