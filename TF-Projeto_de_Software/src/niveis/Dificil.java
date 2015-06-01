package niveis;

import interfaces.Nivel;

public class Dificil implements Nivel{
	int tentativasRestantes = 6;
	
	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		switch (quantErro) {
		case 1:
			//desenha cabeça com olhos
			break;

		default:
			break;
		}
	}
	
	public int getTentativasRestantes() {
		return tentativasRestantes;
	}
}
