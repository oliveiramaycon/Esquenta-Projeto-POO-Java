package modelo.usuario.exceptions;


public class SenhaNaoIgualAConfirmacao extends Exception {
	
	public SenhaNaoIgualAConfirmacao() {
	super("Senha n�o igual a confirmacao!!! ");	
	}
	
	public SenhaNaoIgualAConfirmacao (String msg) {
	super(msg);
	}
	
	
}
