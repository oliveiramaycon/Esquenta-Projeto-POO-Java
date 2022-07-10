package modelo.exceptions;

public class UsuarioExistenteException extends Exception{

	public UsuarioExistenteException() {
		super("usuário já possui cadastro!");
	}
	
}
