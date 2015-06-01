package niveis;

import interfaces.Nivel;

public class Facil implements Nivel {
	int tentativasRestantes = 13;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
