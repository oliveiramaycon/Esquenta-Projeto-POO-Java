package modelo;

import java.util.ArrayList;

public class ProgramaDeTv {

	private long id;
	private String nome;
	private TipoPrograma tipo;
	private Canal canal;
	private ArrayList<String> diasDaSemana;
	
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
	public ArrayList<String> getDiasDaSemana() {
		return diasDaSemana;
	}
	public void setDiasDaSemana(ArrayList<String> diasDaSemana) {
		this.diasDaSemana = diasDaSemana;
	}
	public Canal getCanal() {
		return canal;
	}
	public void setCanal(Canal canal) {
		this.canal = canal;
	}
	
	
	public ProgramaDeTv(String nome,TipoPrograma tipo, Canal canal,ArrayList<String> diasDaSemana) {
		setNome(nome);
		setDiasDaSemana(diasDaSemana);
		setTipo(tipo);
		setCanal(canal);
		this.id = System.currentTimeMillis();
	}
	
	public String toString() {
		return "Nome do programa: " + this.nome;
	}
}
