package modelo.usuario.exceptions;

public class ValidadorDeEmailExecption extends Exception{
	
	
	public ValidadorDeEmailExecption() {
		super("[E-mail] para validado sera precisso @gmail.com ou caracteris validos!!");
	}
	
	public ValidadorDeEmailExecption(String msg) {
		super(msg);
	}
}
