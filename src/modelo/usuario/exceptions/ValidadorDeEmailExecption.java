package modelo.usuario.exceptions;

public class ValidadorDeEmailExecption extends Exception{
	
	
	public ValidadorDeEmailExecption() {
		super("[E-mail] para validado sera preciso @gmail.com ou caracteres validos!!");
	}
	
	public ValidadorDeEmailExecption(String msg) {
		super(msg);
	}
}
