package excecoes;

public class FalhaNoCadastroException extends Exception{
	
	public FalhaNoCadastroException() {
		super("Ocorreu uma falha durante o cadastro!");
	}
	
	public FalhaNoCadastroException(String msg) {
		super(msg);
	}
}
