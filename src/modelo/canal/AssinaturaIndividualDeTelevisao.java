package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class AssinaturaIndividualDeTelevisao extends Canal {
	private int numero;

	public AssinaturaIndividualDeTelevisao(String nome, int numero) {
		super(nome, TipoCanal.ASSINATURA_INDIVIDUAL_DE_TELEVISAO);
		this.numero = numero;
	}

	public int getNumero() {
		return numero;
	}
}