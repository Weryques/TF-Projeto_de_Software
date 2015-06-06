package principal;
import java.io.*;
import java.util.*;
import estrategias.LetraPorLetra;
import estrategias.TodasLetras;
import observadores.*;
import niveis.*;
import temas.*;

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws Exception, IOException{
		int modo;
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
		Controle controle = new Controle();
			
		PalavraContext palavraCont = new PalavraContext();
		
		Estrategia estrategia = new Estrategia(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle);
		
		palavraCont.setLetraPorLetra(new LetraPorLetra(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle));
		palavraCont.setTodasLetras(new TodasLetras(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle));
		
		modo = visao.menuEstrategia();
		
		controle.definirEstrategia(modo, palavraCont);
		
	}

	
}