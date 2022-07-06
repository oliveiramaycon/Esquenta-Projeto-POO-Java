package excecoes;

public class UsuarioExistenteException extends Exception{

	public UsuarioExistenteException() {
		super("usuário já possui cadastro!");
	}
	
}
