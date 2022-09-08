package modelo.usuario.exceptions;

public class SenhaCurtaException extends Exception {

	public SenhaCurtaException() {
		super("[Senha] e muito {Curta}");
	}
	public SenhaCurtaException(String msg) {
		super(msg);
	}
}
