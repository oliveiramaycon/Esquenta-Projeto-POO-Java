package modelo.programa;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.programa.enums.EnumFavorito;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;

public abstract class ProgramaDeTv {

	private long id;
	private String nome;
	private TipoPrograma tipo;
	private Canal canal;
	private Status status;
	private EnumFavorito favorito;
	private String horario;
	private String temporadas;
	private ArrayList<DayOfWeek> diasDaSemana;

	public ProgramaDeTv(String nome, Canal canal,ArrayList<DayOfWeek> diasDaSemana,
			Status status,String horario, String teporadas) {
		setNome(nome);
		setTemporadas(temporadas);
		setDiasDaSemana(diasDaSemana);
		setCanal(canal);
		this.id = System.currentTimeMillis();
		this.horario = horario;
	}
	public void setTipo(TipoPrograma tipo) {
		this.tipo = tipo;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public EnumFavorito getFavorito() {
		return favorito;
	}

	public void setFavorito(EnumFavorito favorito) {
		this.favorito = favorito;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoPrograma getTipo() {
		return tipo;
	}

	public ArrayList<DayOfWeek> getDiasDaSemana() {
		return diasDaSemana;
	}

	public void setDiasDaSemana(ArrayList<DayOfWeek> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}

	public Canal getCanal() {
		return canal;
	}

	public void setCanal(Canal canal) {
		this.canal = canal;
	}

	public String getHorario() {
		return horario;
	}
	public String getTemporadas() {
		return temporadas;
	}
	public void setTemporadas(String temporadas) {
		this.temporadas = temporadas;
	}
	
	public String toString() {
		return "Nome do programa: " + this.nome;
	}
}
