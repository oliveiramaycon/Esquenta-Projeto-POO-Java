package modelo;

import java.time.DayOfWeek;
import java.util.ArrayList;

import EnumsPrograma.EnumFavorito;
import EnumsPrograma.Status;
import EnumsPrograma.TipoPrograma;

public abstract class ProgramaDeTv {

	private long id;
	private String nome;
	private TipoPrograma tipo;
	private Canal canal;
	private EnumFavorito favorito;
	private String horario;
	private ArrayList<DayOfWeek> diasDaSemana;

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

	public void setTipo(TipoPrograma tipo) {
		this.tipo = tipo;
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

	public ProgramaDeTv(String nome, Canal canal,
			ArrayList<DayOfWeek> diasDaSemana, Status status, String horario) {
		setNome(nome);
		setDiasDaSemana(diasDaSemana);
		setCanal(canal);
		this.id = System.currentTimeMillis();
		this.horario = horario;
	}

	public String toString() {
		return "Nome do programa: " + this.nome;
	}
}
