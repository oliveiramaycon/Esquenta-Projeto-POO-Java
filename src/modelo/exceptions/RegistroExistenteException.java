package modelo.exceptions;

public class RegistroExistenteException extends Exception{

	public RegistroExistenteException() {
		super("Esse registro já existe!");
		
	}
	
}
