package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class RealityShows extends ProgramasContinuos {

	public RealityShows(String nome, ArrayList<DayOfWeek> dia, Canal canal, String horario,
			Status status, String temporadas) {
		super(nome, dia, canal, horario, status, temporadas);
		System.out.println(temporadas);
		setTipo(TipoPrograma.REALITY_SHOW);
	}
}
