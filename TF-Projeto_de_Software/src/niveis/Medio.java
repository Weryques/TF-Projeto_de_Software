package niveis;

import interfaces.Nivel;

public class Medio implements Nivel {
	int tentativasRestantes = 10;

	@Override
	public void desenhaCorpo(int quantErro, char[][] forca) {
		// TODO Auto-generated method stub
		
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}

}
