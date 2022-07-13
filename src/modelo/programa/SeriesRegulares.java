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
	private int temporada;
	private Status status;

	public SeriesRegulares(String nome, ArrayList<DayOfWeek> dia, Canal canal,
			Genero genero, int temporada, Status status, String horario) {
		super(nome, canal, dia, status, horario);
		setFavorito(EnumFavorito.NAO_FAVORITO);
		setTipo(TipoPrograma.SERIES_REGULARES);
		this.genero = genero;
		this.status = status;
	}

	public Genero getGenero() {
		return genero;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public int getTemporada() {
		return temporada;
	}

	public Status getStatus() {
		return status;
	}

	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}