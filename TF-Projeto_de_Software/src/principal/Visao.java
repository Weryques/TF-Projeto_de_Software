package principal;

import java.util.Scanner;

/**Classe que exibe informações que não são de interesse dos observers
 * @author weryquessantos
 *
 */
public class Visao {
	Scanner scan = new Scanner(System.in);
	
	/**Exibe a mensagem para que o usuário digite uma letra
	 * 
	 */
	public void digiteLetra() {
		System.out.println();
		System.out.print("Digite uma letra (MAIÚSCULA): ");		
	}

	/**Exibe a mensagem caso uma opção no menu seja invalida
	 * 
	 */
	public void opInvalida() {
		System.out.println("Opção inválida! Tente novamente.");		
	}

	/**Exibe a mensagem de quando o jogo é encerrado
	 * 
	 */
	public void fimJogo() {
		System.out.println();
		System.out.println("JOGO ENCERRADO!");	
	}
	
	/**Exibe o menu de fim de jogo e retorna a opção escolhida no menu
	 * @return escolha2
	 */
	public int menuFimDeJogo(){
		int escolha2 = 0;
		System.out.println("| 1 - Continuar o jogo com o mesmo tema e mesmo nível |");
		System.out.println("| 2 - Trocar de nível e continuar com mesmo tema      |");
		System.out.println("| 3 - Trocar de tema e continuar com mesmo nível      |");
		System.out.println("| 0 - Sair do jogo");
		System.out.print("Aqui: ");
		escolha2 = scan.nextInt();
		return escolha2;
	}

	/**Exibe o menu Tema e retorna a opção escolhida
	 * @return tema
	 */
	public int menuTema() {
		int tema = 0;
		System.out.println("|------Tema------|");
		System.out.println("|----------------|");
		System.out.println("| 1 - Animais    |");
		System.out.println("| 2 - Filmes     |");
		System.out.println("| 3 - Profissões |");
		System.out.println("|----------------|");
		System.out.print("Escolha o tema da palavra: ");
		tema = scan.nextInt();
		return tema;
	}

	/**Exibe o menu Tema ou Aleatorio e retorna a opção escolhida
	 * @return escolha1
	 */
	public int menuTemaOuAleatoria() {
		int escolha1 = 0;
		System.out.println("| 1 - Escolher o tema da palavra              |");
		System.out.println("| 0 - Jogar                                   |");
		System.out.print("Aqui: ");
		escolha1 = scan.nextInt();
		return escolha1;
	}

	/**Exibe o menu Niveis e retorna a opção escolhida
	 * @return nivel
	 */
	public int menuNiveis() {
		int nivel = 0;
		System.out.println("|-----Níveis-----|");
		System.out.println("|----------------|");
		System.out.println("| 1 - Fácil      |");
		System.out.println("| 2 - Médio      |");
		System.out.println("| 3 - Dificil    |");
		System.out.println("|----------------|");
		System.out.print("Escolha o nível de dificuldade: ");
		nivel = scan.nextInt();
		return nivel;
	}
	
	/**Exibe  o menu Estrategia e retorna a opção escolhida
	 * @return escolha3
	 */
	public int menuEstrategia(){
		int escolha3 = 0;
		System.out.println("| 1 - Modo Todas as Letras              |");
		System.out.println("| 0 - Modo Letra por Letra              |");
		System.out.print("Aqui: ");
		escolha3 = scan.nextInt();
		return escolha3;
	}
	
	/**Limpa o console a cada exibição de menus ou outras exibições
	 * 
	 */
	public void limparConsole() {
		for(int i = 0; i < 100; i++){
			System.out.println("\b");
		}
	}
}
