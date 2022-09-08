package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.exceptions.ApresentadorJaCadastrado;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class ProgramasContinuos extends ProgramaDeTv {
	private ArrayList<String> apresentadores;

	public ProgramasContinuos(String nome, ArrayList<DayOfWeek> dia, Canal canal, String horario, Status status,
			String temporadas) {
		super(nome, canal, dia, status, horario, temporadas);

		setTipo(TipoPrograma.PROGRAMA_CONTINUO);
		apresentadores = new ArrayList<>();
	}

	public void setApresentadores(String apresentadores2) throws ApresentadorJaCadastrado {
		boolean achouApresentador = false;
		for (String a : apresentadores) {
			if (a.equals(apresentadores2)) {
				achouApresentador = true;
				throw new ApresentadorJaCadastrado();
			}
		}
		if (!achouApresentador)
			apresentadores.add(apresentadores2);
	}

	public ArrayList<String> getApresentadores() {
		return apresentadores;
	}

}
