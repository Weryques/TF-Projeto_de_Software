package principal;


import java.io.*;
import java.util.*;
import estrategias.LetraPorLetra;
import estrategias.TodasLetras;
import observadores.*;
import niveis.*;
import temas.*;

/**Classe responsável pelo inicio do jogo, tem-se instancias das outras classes do projeto
 * @author weryquessantos
 */

public class Jogo_da_Forca {
	static Scanner scan = new Scanner(System.in);

	/**
	 * @param args
	 * @throws Exception
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception, IOException{
		int modo;
		
		/** Instancia da classe Animais*/
		Animais animais = new Animais();
		
		/** Instancia da classe Filmes*/
		Filmes filmes = new Filmes();
		
		/** Instancia da classe Profissões*/
		Profissoes profissoes = new Profissoes();

		/** Instancia da classe TelaObservavel*/
		TelaObservavel tela = new TelaObservavel();

		/** Instancia da classe FimJogo*/
		FimJogo fimJogo = new FimJogo();
		
		/** Instancia da classe BancoLetrasErradas*/
		BancoLetrasErradas bancoLetras = new BancoLetrasErradas();
		
		/** Instancia da classe Forca*/
		Forca forcaI = new Forca();
		
		/** Instancia da classe PalavraAnonima*/
		PalavraAnonima palavraAnonima = new PalavraAnonima();

		/** Instancia da classe Dificil*/
		Dificil dificil = new Dificil();
		
		/** Instancia da classe Facil*/
		Facil facil = new Facil();
		
		/** Instancia da classe Medio*/
		Medio medio = new Medio();
		
		/** Instancia da classe Visao*/
		Visao visao = new Visao();
		
		/** Instancia da classe Controle*/
		Controle controle = new Controle();
			
		/** Instancia da classe PalavraContext*/
		PalavraContext palavraCont = new PalavraContext();
			
		/** Inicializa as instancias em PalavraCont*/
		palavraCont.setLetraPorLetra(new LetraPorLetra(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle));
		palavraCont.setTodasLetras(new TodasLetras(palavraCont, visao, animais, filmes, profissoes, tela, fimJogo, bancoLetras, forcaI, palavraAnonima, dificil, facil, medio, controle));
		
		/** Chama o menu de Estraegias e recebe a opção escolhida*/
		modo = visao.menuEstrategia();
		
		/** Define a estrategia a partir do @param modo*/
		controle.definirEstrategia(modo, palavraCont);
		
	}

	
}