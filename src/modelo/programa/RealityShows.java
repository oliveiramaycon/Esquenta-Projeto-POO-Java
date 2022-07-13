package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class RealityShows extends ProgramasContinuos {

	public RealityShows(String nome, ArrayList<DayOfWeek> dia, Canal canal, String horario, Status status) {
		super(nome, canal, dia, horario, status);
		setTipo(TipoPrograma.REALITY_SHOW);
	}
}
