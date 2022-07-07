package HerancaPrograma;

import java.time.DayOfWeek;
import java.util.ArrayList;

import EnumsPrograma.Status;
import EnumsPrograma.TipoPrograma;
import modelo.Canal;

public class RealityShows extends ProgramasContinuos {

	public RealityShows(String nome, ArrayList<DayOfWeek> dia, Canal canal, String horario, Status status) {
		super(nome, canal, dia, horario, status);
		setTipo(TipoPrograma.REALITY_SHOW);
	}
}
