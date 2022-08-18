package modelo.usuario;

import modelo.usuario.exceptions.LoginComEspacosException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import modelo.usuario.exceptions.StringComMenosCarecterisExecption;
import modelo.usuario.exceptions.ValidadorDeEmailExecption;

public class ValidadorUsuario {

	/*
	 * ----------------------------------------------------EXCEPTIONS DE VALIDACAO
	 * DE LOGIN E SENHA E E-MAIL:
	 */

	public static void validadorDeLogin(String login)
			throws LoginComEspacosException, StringComMenosCarecterisExecption{
		digitoVazio(login);
		tamanhoString(login);
	}

	public static void validadorDeSenha(String senha, String confirmado)
			throws StringComMenosCarecterisExecption , SenhaSemMinusculosException, SenhaSemCaracterMaiusculaExecption,
		SenhaSemNumerosException, SenhaNaoIgualAConfirmacao {
		
		tamanhoString(senha);
		verificarLetraMinuscula(senha);
		verificarLetraMaiuscula(senha);
		verificarNumeros(senha);
		verificadorDeSenhaNaoIgual(senha, confirmado);
	}
	
	/*
	 * -----------------------------------------------------METODOS UTEIS PARA O
	 * USUARIO:
	 */
	
	public static boolean digitoVazio(String string) throws LoginComEspacosException {
		if (string.contains(" ")) {
			throw new LoginComEspacosException();
		}
		return true;

	}

	public static boolean tamanhoString(String string) throws StringComMenosCarecterisExecption {
		if(string.length() < 5) {
			throw new StringComMenosCarecterisExecption();
		}
		return true;
	}

	public static boolean verificarLetraMinuscula(String s) throws SenhaSemMinusculosException {
		for (int c = 0; c < s.length(); c++) {
			if (Character.isLowerCase(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemMinusculosException();
	}

	public static boolean verificarLetraMaiuscula(String s) throws SenhaSemCaracterMaiusculaExecption {
		for (int c = 0; c < s.length(); c++) {
			if (Character.isUpperCase(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemCaracterMaiusculaExecption();
	}

	public static boolean verificarNumeros(String s) throws SenhaSemNumerosException {
		for (int c = 0; c < s.length(); c++) {
			if (Character.isDigit(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemNumerosException();
	}

	public static boolean verificadorDeSenhaNaoIgual(String senha, String confirmacao) throws SenhaNaoIgualAConfirmacao {
		if (senha.equals(confirmacao)) {
			return true;
		}
		throw new SenhaNaoIgualAConfirmacao();
	}


	// VERIFICA O EMAIL PARA PROCURAR CARACTERS VALIDOS:
	public static boolean verificaEmail(String userEmail) throws ValidadorDeEmailExecption {
	
		String regex = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$";

		if (userEmail.matches(regex)) {
			return true;
		} else {
			throw new ValidadorDeEmailExecption();
		}
	}
	
}

	

