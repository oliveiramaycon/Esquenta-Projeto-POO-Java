package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class AssinaturaIndividualDeBroadcasting extends Canal {
	private String link;

	public AssinaturaIndividualDeBroadcasting(String nome, String link) {
		super(nome, TipoCanal.ASSINATURA_INDIVIDUAL_DE_BROADCASTING);
		this.link = link;
	}

	public String getLink() {
		return link;
	}
}
