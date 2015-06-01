package principal;

public class Visao {
	public void letraRepetida(){
		System.out.println("VOCÊ JÁ DIGITOU ESSA LETRA!");
	}

	public void digiteLetra() {
		System.out.println();
		System.out.print("Digite uma letra (MAIÚSCULA): ");		
	}

	public void opInvalida() {
		System.out.println("Opção inválida! Tente novamente.");		
	}

	public void fimJogo() {
		System.out.println("JOGO ENCERRADO!");	
	}
}
