package modelo.canal;

import modelo.canal.enums.TipoCanal;
//ESSE FOI O CANAL QUE FICO MESMO COM O GIT PULL

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