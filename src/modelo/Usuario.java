package modelo;

public class Usuario {

	private String nome;
	private String email;
	private String login;
	private String senha;
	private String confirmacaoDeSenha;

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
		super();
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.confirmacaoDeSenha = confirmacaoDeSenha;
	}

	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ ", confirmacaoDeSenha=" + confirmacaoDeSenha + "]";
	}

}
