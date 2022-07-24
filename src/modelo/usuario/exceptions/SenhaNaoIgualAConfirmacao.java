package modelo.usuario.exceptions;


public class SenhaNaoIgualAConfirmacao extends Exception {
	
	public SenhaNaoIgualAConfirmacao() {
	super("Senha não igual a confirmacao!!! ");	
	}
	
	public SenhaNaoIgualAConfirmacao (String msg) {
	super(msg);
	}
	
	
}
