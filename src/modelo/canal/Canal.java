package modelo.canal;

import modelo.canal.enums.TipoCanal;

public abstract class Canal {

	private String nome;
	private TipoCanal tipoCanal;
	private long id;
	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCanal getTipoCanal() {
		return tipoCanal;
	}

	public void setTipoCanal(TipoCanal tipoCanal) {
		this.tipoCanal = tipoCanal;
	}

	public Canal(String nome, TipoCanal tipoCanal) {
		setNome(nome);
		setTipoCanal(tipoCanal);
		id = System.currentTimeMillis();
	}

	

	@Override
	public String toString() {
		return "Canal [nome=" + nome + ", tipoCanal=" + tipoCanal + ", id=" + id + "]";
	}

	public boolean equals(Canal canal) {
		return canal.getNome().equals(this.nome) || canal.getId() == this.id;
	}
}
