package modelo.usuario.exceptions;

public class SenhaSemMinusculosException extends Exception {

	public SenhaSemMinusculosException() {
		super("[Senha] Deve possuir caracteris {Minusculos} ");
	}
	
	public SenhaSemMinusculosException(String msg) {
		super(msg);
	}
}
