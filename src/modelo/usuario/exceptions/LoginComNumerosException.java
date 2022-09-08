package modelo.usuario.exceptions;

public class LoginComNumerosException extends Exception {
	
	public LoginComNumerosException() {
		super("[Login] nao deve possuir {Numeros} ");
	}

	 public LoginComNumerosException(String msg) {
		 super(msg);
	 }
}
