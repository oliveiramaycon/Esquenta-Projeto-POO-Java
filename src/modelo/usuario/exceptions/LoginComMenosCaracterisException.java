package modelo.usuario.exceptions;


public class LoginComMenosCaracterisException extends Exception {

	
	public  LoginComMenosCaracterisException() {
		super("[Login] Nao possui o caracteris o Suficiente");
	}
	
	public LoginComMenosCaracterisException(String msg) {
		super(msg);
	}
}
