package niveisStrategy;

import interfaces.TipoNiveisStrategy;

public class Dificil implements TipoNiveisStrategy{
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
