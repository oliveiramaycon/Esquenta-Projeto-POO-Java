package modelo;

import EnumCanal.TipoCanal;

public abstract class Canal {

	private String nome;
	private TipoCanal tipoCanal;

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
	}

	@Override
	public String toString() {
		return "Canal [nome=" + nome + ", tipoCanal=" + tipoCanal + "]";
	}

	public boolean equals(Canal canal) {
		return canal.getNome().equals(this.nome);
	}
}
