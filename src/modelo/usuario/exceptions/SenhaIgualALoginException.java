package modelo.usuario.exceptions;


public class SenhaIgualALoginException extends Exception {
	
	public SenhaIgualALoginException() {
	super("[Login] e [Senha] sao {Iguais} ");	
	}
	
	public SenhaIgualALoginException (String msg) {
	super(msg);
	}
	
	
}
