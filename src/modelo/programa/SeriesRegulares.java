package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Estilo;
import modelo.programa.enums.Genero;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public class SeriesRegulares extends ProgramaDeTv {
	private Genero genero;
	private Estilo estilo;

	public SeriesRegulares(String nome, ArrayList<DayOfWeek> dia, Canal canal,
			Genero genero, Status status, String horario, String temporadas) {
		super(nome, canal, dia, status, horario, temporadas);
		setTipo(TipoPrograma.SERIES_REGULARES);
		this.genero = genero;
	}

	public Genero getGenero() {
		return genero;
	}

	public Estilo getEstilo() {
		return estilo;
	}
	
}