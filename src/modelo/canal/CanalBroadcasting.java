package modelo.canal;

import modelo.canal.enums.TipoCanal;
import modelo.usuario.Usuario;

public class CanalBroadcasting extends Canal {

	private String link;

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public CanalBroadcasting(String nome, TipoCanal tipoCanal, String link, Usuario dono) {
		super(nome, tipoCanal, dono);
		this.link = link;
	}

}
