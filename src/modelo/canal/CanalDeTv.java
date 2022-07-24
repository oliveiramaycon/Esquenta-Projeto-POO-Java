package modelo.canal;

import modelo.canal.enums.TipoCanal;
import modelo.usuario.Usuario;

public class CanalDeTv extends Canal {
	
	private int numeroCanal;
	
	
	public int getNumeroCanal() {
		return numeroCanal;
	}
	public void setNumeroCanal(int numeroCanal) {
		this.numeroCanal = numeroCanal;
	}
	
	public CanalDeTv(String nome, TipoCanal tipoCanal, int numeroCanal, Usuario dono) {
		super(nome, tipoCanal, dono);
		this.numeroCanal = numeroCanal;
		
	}

	
	
}
