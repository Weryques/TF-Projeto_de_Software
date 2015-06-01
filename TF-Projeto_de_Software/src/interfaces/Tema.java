package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Tema {
	public String getPalavraArquivo() throws IOException, FileNotFoundException;
}
