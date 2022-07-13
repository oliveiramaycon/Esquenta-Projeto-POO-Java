package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class PacoteDeAssinatura extends Canal {
	private int numero;

	public PacoteDeAssinatura(String nome, int numero) {
		super(nome, TipoCanal.PACOTE_DE_ASSINATURA);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
}
