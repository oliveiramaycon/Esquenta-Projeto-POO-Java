package modelo.usuario;

import java.util.ArrayList;

import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.exceptions.ProgramaJaAdicionado;
import modelo.programa.exceptions.ProgramaNaoFavoritado;

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
