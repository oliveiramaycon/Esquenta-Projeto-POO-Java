package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class CanalBroadcasting extends Canal{
	
	private String link;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	public CanalBroadcasting(String nome, TipoCanal tipoCanal, String link) {
		super(nome, tipoCanal);
		this.link = link;
		// TODO Auto-generated constructor stub
	}

	
	
}
