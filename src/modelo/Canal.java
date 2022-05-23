package modelo;

public class Canal {

	private String nome;
	private String tipoCanal;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipoCanal() {
		return tipoCanal;
	}
	public void setTipoCanal(String tipoCanal) {
		this.tipoCanal = tipoCanal;
	}
	
	
	
	public Canal() {
		
	}
	
	public Canal(String nome, String tipoCanal) {
		setNome(nome);
		setTipoCanal(tipoCanal);
	}
	
	public String toString() {
		return "nome: " + nome;
	}
	
	public boolean equals(Canal canal) {
		return canal.getNome().equals(this.nome);
	}
}
