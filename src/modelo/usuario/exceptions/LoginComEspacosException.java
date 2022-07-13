package modelo.usuario.exceptions;

public class LoginComEspacosException extends Exception {
	
	public LoginComEspacosException() {
		super("[Login] Possui espacos em {Branco}");
	}
	
	public LoginComEspacosException(String msg) {
		super(msg);
	}
}
