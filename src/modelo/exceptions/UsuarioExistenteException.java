package modelo.exceptions;

public class UsuarioExistenteException extends Exception {

	public UsuarioExistenteException() {
		super("usu�rio j� possui cadastro!");
	}

}
