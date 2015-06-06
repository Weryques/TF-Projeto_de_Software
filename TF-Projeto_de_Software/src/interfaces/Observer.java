package interfaces;

public interface Observer {
	public void atualiza(char[] copiaTracejada, String resultado, int tentativasRestantes, char[] erradas);
	public Observer cria_se();
}
