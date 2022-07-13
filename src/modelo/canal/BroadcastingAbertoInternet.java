package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class BroadcastingAbertoInternet extends Canal {
	private String link;

	public BroadcastingAbertoInternet(String indentificador, TipoCanal tipoCanal, String link) {
		super(indentificador, TipoCanal.BROADCASTING_ABERTO_NA_INTERNET);
		this.link = link;
	}

	public String getLink() {
		return link;
	}
}
