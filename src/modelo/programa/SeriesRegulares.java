package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.programa.enums.Estilo;
import modelo.programa.enums.Genero;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class SeriesRegulares extends ProgramaDeTv {
	private Genero genero;
	private Estilo estilo;

	public SeriesRegulares(String nome, ArrayList<DayOfWeek> dia, Canal canal, Status status, String horario,
			String temporadas, Genero genero, Estilo estilo) {
		super(nome, canal, dia, status, horario, temporadas);
		setTipo(TipoPrograma.SERIES_REGULARES);
		setGenero(genero);
		setEstilo(estilo);
	}

	public Genero getGenero() {
		return genero;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}
}