package modelo.usuario.exceptions;

public class SenhaSemNumerosException extends Exception {

	public SenhaSemNumerosException() {
		super("[Senha] deve possuir {Numeros}");
	}
	
	public SenhaSemNumerosException(String msg) {
		super(msg);
	}
}
