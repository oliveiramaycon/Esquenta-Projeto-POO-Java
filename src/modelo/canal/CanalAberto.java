package modelo.canal;

import modelo.canal.enums.TipoCanal;
// ESSE FOI O CANAL QUE FICO MESMO COM O GIT PULL
public class CanalAberto extends Canal {
	private int numero;

	public CanalAberto(String indentificador, int numero) {
		super(indentificador, TipoCanal.CANAL_ABERTO_DE_TELEVISAO);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
}