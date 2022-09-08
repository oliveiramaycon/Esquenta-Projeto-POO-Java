package modelo.usuario.exceptions;

public class SenhaSemCaracterMaiusculaExecption extends Exception {
	
	public SenhaSemCaracterMaiusculaExecption() {
		super("[Senha] deve possuir um caracter {Maiuscula}");
	}
	public SenhaSemCaracterMaiusculaExecption(String msg) {
		super(msg);
	}
	

}
