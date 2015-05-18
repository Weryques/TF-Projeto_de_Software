package interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface TipoTemaStrategy {
	public String getPalavraArquivo() throws IOException, FileNotFoundException;
}
