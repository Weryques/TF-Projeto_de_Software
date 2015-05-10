package niveis;

import interfaces.TipoNiveis;

public class Dificil implements TipoNiveis{
	
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
}
