package modelo.programa.exceptions;

public class TipoDeProgramaNaoExisteException extends Exception {
	public TipoDeProgramaNaoExisteException() {
		super("Não existe esse tipo de programa!");
	}

}
