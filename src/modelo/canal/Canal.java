package modelo.canal;

import java.time.LocalDateTime;
import java.util.ArrayList;

import modelo.canal.enums.TipoCanal;
import modelo.programa.ProgramaDeTv;
import modelo.usuario.Usuario;

public abstract class Canal {

	private String nome;
	private TipoCanal tipoCanal;
	private long id;
	private ArrayList<ProgramaDeTv> programas;
	private LocalDateTime dataDeCadastro;
	private LocalDateTime dataDeAtualizacao;
	private Usuario dono;

	public Canal(String nome, TipoCanal tipoCanal, Usuario dono) {
		this.nome = nome;
		this.tipoCanal = tipoCanal;
		id = System.currentTimeMillis();
		programas = new ArrayList<ProgramaDeTv>();
		dataDeCadastro = LocalDateTime.now();
		this.dono = dono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoCanal getTipoCanal() {
		return tipoCanal;
	}

	public void setTipoCanal(TipoCanal tipoCanal) {
		this.tipoCanal = tipoCanal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ArrayList<ProgramaDeTv> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<ProgramaDeTv> programas) {
		this.programas = programas;
	}

	public LocalDateTime getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(LocalDateTime dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	public LocalDateTime getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}

	public void setDataDeAtualizacao(LocalDateTime dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public boolean equals(Canal canal) {
		return canal.getNome().equals(this.nome) || canal.getId() == this.id;
	}

	@Override
	public String toString() {
		return "Canal [nome=" + nome + ", tipoCanal=" + tipoCanal + ", id=" + id + ", programas=" + programas
				+ ", dataDeCadastro=" + dataDeCadastro + ", dataDeAtualizacao=" + dataDeAtualizacao + ", dono=" + dono
				+ "]";
	}

}
