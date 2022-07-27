package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.exceptions.ApresentadorJaCadastrado;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class ProgramasContinuos extends ProgramaDeTv {
	private ArrayList<String> apresentadores;

	public ProgramasContinuos(String nome, Canal canal, ArrayList<DayOfWeek> dia,
			String horario, Status status,String temporadas) {
		super(nome, canal, dia, status, horario, temporadas);
		setTipo(TipoPrograma.PROGRAMA_CONTINUO);
	}

	public void setApresentadores(String apresentador) throws ApresentadorJaCadastrado {
		boolean achouApresentador = false;
		for (String a : apresentadores) {
			if (a.equals(apresentador)) {
				achouApresentador = true;
				throw new ApresentadorJaCadastrado();
			}
		}
		if (!achouApresentador)
			apresentadores.add(apresentador);
	}

	public ArrayList<String> getApresentadores() {
		return apresentadores;
	}

}