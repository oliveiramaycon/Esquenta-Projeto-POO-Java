package modelo.usuario;

import java.util.ArrayList;

import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.exceptions.ProgramaJaAdicionado;
import modelo.programa.exceptions.ProgramaNaoFavoritado;
import modelo.usuario.exceptions.LoginComEspacosException;
import modelo.usuario.exceptions.LoginComMenosCaracterisException;
import modelo.usuario.exceptions.LoginComNumerosException;
import modelo.usuario.exceptions.SenhaCurtaException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import modelo.usuario.exceptions.ValidadorDeEmailExecption;

public class Usuario {

	private String nome;
	private String email;
	private String login;
	private String senha;
	private String confirmacaoDeSenha;
	private ArrayList<ProgramaDeTv> programasFavoritos;

	public ArrayList<ProgramaDeTv> getProgramasFavoritos() {
		return programasFavoritos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmacaoDeSenha() {
		return confirmacaoDeSenha;
	}

	public void setConfirmacaoDeSenha(String confirmacaoDeSenha) {
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	public Usuario(String nome, String email, String login, String senha, String confirmacaoDeSenha) {
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.confirmacaoDeSenha = confirmacaoDeSenha;
		this.programasFavoritos = new ArrayList<ProgramaDeTv>();
	}

	public Usuario() {
	}

	/*
	 * ----------------------------------------------------EXCEPTIONS DE VALIDACAO
	 * DE LOGIN E SENHA E E-MAIL:
	 */

	public void validadorDeLogin(String login)
			throws LoginComEspacosException, LoginComMenosCaracterisException, LoginComNumerosException {
		if (login.contains(" ")) {
			throw new LoginComEspacosException();
		}
		if (login.length() < 5) {
			throw new LoginComMenosCaracterisException();
		}

	}

	public void validadorDeSenha(String senha, String confirmado)
			throws SenhaCurtaException, SenhaSemMinusculosException, SenhaSemCaracterMaiusculaExecption,
			SenhaSemNumerosException, SenhaNaoIgualAConfirmacao {
		if (senha.length() < 5) {
			throw new SenhaCurtaException();
		}
		verificarLetraMinuscula(senha);
		verificarLetraMaiuscula(senha);
		verificarNumeros(senha);
		verificadorDeSenhaNaoIgual(senha, confirmado);
	}

	public void validadorDeEmail(String Email) throws ValidadorDeEmailExecption {
		verificaEmail(Email);
	}

	/*
	 * -----------------------------------------------------METODOS UTEIS PARA O
	 * USUARIO:
	 */

	public boolean verificarLetraMinuscula(String s) throws SenhaSemMinusculosException {
		for (int c = 0; c < s.length(); c++) {
			if (Character.isLowerCase(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemMinusculosException();
	}

	public boolean verificarLetraMaiuscula(String s) throws SenhaSemCaracterMaiusculaExecption {
		boolean achei = false;
		for (int c = 0; c < s.length(); c++) {
			if (Character.isUpperCase(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemCaracterMaiusculaExecption();
	}

	public boolean verificarNumeros(String s) throws SenhaSemNumerosException {
		for (int c = 0; c < s.length(); c++) {
			if (Character.isDigit(s.charAt(c))) {
				return true;
			}
		}
		throw new SenhaSemNumerosException();
	}

	public boolean verificadorDeSenhaNaoIgual(String senha, String confirmacao) throws SenhaNaoIgualAConfirmacao {
		if (senha.equals(confirmacao)) {
			return true;
		}
		throw new SenhaNaoIgualAConfirmacao();
	}

// Refazer codigo para confirma a senha:
//	//public boolean verificaIgualdade(String s) throws SenhaIgualALoginException {
//		//boolean achei = false;
//		//for (int c = 0; c < s.length() - 1; c++) {
//			if (s.charAt(c) == s.charAt(c + 1)) {
//				return true;
//			}
//		}
//		throw new SenhaIgualALoginException();
//	}

	// VERIFICA O EMAIL PARA PROCURAR CARACTERS VALIDOS:
	public boolean verificaEmail(String userEmail) throws ValidadorDeEmailExecption {
		// String email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		// Pattern patternEmail = Pattern.compile(email,Pattern.CASE_INSENSITIVE);
		// Matcher procura = patternEmail.matcher(userEmail);
		// return procura.find();
		String regex = "[A-Za-z0-9]+@+gmail.com$";

		if (userEmail.matches(regex)) {
			return true;
		} else {
			throw new ValidadorDeEmailExecption();
		}
	}

	public boolean addPrograma(ProgramaDeTv p) throws ProgramaJaAdicionado, ProgramaNaoFavoritado {
		if (p.getFavorito() == EnumFavorito.NAO_FAVORITO)
			throw new ProgramaNaoFavoritado();
		for (ProgramaDeTv pdtv : getProgramasFavoritos()) {
			if (pdtv.getId() == p.getId()) {
				throw new ProgramaJaAdicionado();
			}
		}
		programasFavoritos.add(p);
		return true;
	}

	public int obterQuantidadeDeProgramasFavoritos(ArrayList<ProgramaDeTv> programas) {
		int cont = 0;
		if (programas.size() > 0) {
			for (ProgramaDeTv programa : programas) {
				if (this.programasFavoritos.contains(programa)) {
					cont++;
				}
			}
		}
		return cont;
	}

	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ ", confirmacaoDeSenha=" + confirmacaoDeSenha + "]";
	}

}
