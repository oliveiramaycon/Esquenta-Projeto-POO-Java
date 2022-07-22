package modelo.canal;

import modelo.canal.enums.TipoCanal;

public class CanalDeTv extends Canal {
	
	private int numeroCanal;
	
	
	public int getNumeroCanal() {
		return numeroCanal;
	}
	public void setNumeroCanal(int numeroCanal) {
		this.numeroCanal = numeroCanal;
	}
	
	public CanalDeTv(String nome, TipoCanal tipoCanal, int numeroCanal) {
		super(nome, tipoCanal);
		this.numeroCanal = numeroCanal;
		// TODO Auto-generated constructor stub
	}

	
	
}
