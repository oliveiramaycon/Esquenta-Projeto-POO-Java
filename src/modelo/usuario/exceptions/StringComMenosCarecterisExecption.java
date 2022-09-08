package modelo.usuario.exceptions;

public class StringComMenosCarecterisExecption extends Exception {

	
	public  StringComMenosCarecterisExecption() {
		super("Nao possui o caracteris o Suficiente");
	}
	
	public StringComMenosCarecterisExecption(String msg) {
		super(msg);
	}
}
