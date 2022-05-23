package utilidades;

import java.util.ArrayList;

import modelo.Canal;
import modelo.ProgramaDeTv;
import modelo.TipoPrograma;

public class CentralDeInformacoes {

	private ArrayList<ProgramaDeTv> programas = new ArrayList<ProgramaDeTv>();
	private ArrayList<Canal> canais = new ArrayList<Canal>();

	public ArrayList<ProgramaDeTv> getProgramas() {
		return programas;
	}

	public void setProgramas(ArrayList<ProgramaDeTv> programas) {
		this.programas = programas;
	}

	public ArrayList<Canal> getCanais() {
		return canais;
	}

	public void setCanais(ArrayList<Canal> canais) {
		this.canais = canais;
	}

	
	/*
	 *  ---------------------------------------------- MÉTODOS UTILITÁRIOS RELACIONADO A ENTENDIDADE PROGRAMA
	 */
	
	public boolean AdicionarProgramaDeTv(ProgramaDeTv programa) {
		if (recuperarProgramaDetvPeloId(programa.getId()) != null) {
			return false;
		}

		if (programa.getCanal() == null) {
			return false;
		}

		programas.add(programa);
		return true;
	}

	public ProgramaDeTv recuperarProgramaDetvPeloId(long id) {

		for (ProgramaDeTv programa : programas) {
			if (programa.getId() == id) {
				return programa;
			}
		}
		return null;
	}

	public void exibirProgramas() {
		System.out.println(programas.toString());
	}
	
	public void exibirTiposDeProgramas() {
		System.out.println(obterTiposDeProgramas().toString());
	}

	public ArrayList<ProgramaDeTv> buscarProgramasPeloTipo(TipoPrograma tipoPrograma) {
		ArrayList<ProgramaDeTv> programasEncontrados = new ArrayList<ProgramaDeTv>();

		for (ProgramaDeTv programa : programas) {
			if (programa.getTipo().equals(tipoPrograma)) {
				programasEncontrados.add(programa);
			}
		}
		return programasEncontrados;
	}

	public void exibirProgramasPeloTipo(TipoPrograma tipoPrograma) {
		ArrayList<ProgramaDeTv> programasDeMesmoTipo = buscarProgramasPeloTipo(tipoPrograma);
		if (programasDeMesmoTipo.isEmpty()) {
			System.out.println("Nenhum programa do tipo " + tipoPrograma + " foi encontrado.");
		} else {
			System.out.println(programasDeMesmoTipo.toString());
		}
	}
	
	public ArrayList<ProgramaDeTv> buscarProgramasPorCanal(String nomeDoCanal) {
		ArrayList<ProgramaDeTv> programasEncontrados = new ArrayList<ProgramaDeTv>();

		for (ProgramaDeTv programa : programas) {
			if (programa.getCanal().getNome().equals(nomeDoCanal)) {
				programasEncontrados.add(programa);
			}
		}
		return programasEncontrados;
	}
	
	public ArrayList<String> obterTiposDeProgramas() {
		ArrayList<String> tipos = new ArrayList<String>();
		for (TipoPrograma tipo : TipoPrograma.values()) {
			tipos.add(tipo.toString());
		}
		return tipos;
	}

	public ArrayList<ProgramaDeTv> obterProgramasComTransmissãoNaDataAtual() {
		ArrayList<ProgramaDeTv> programasDoDia = new ArrayList<ProgramaDeTv>();
		String diaDaSemana = Datas.obterDiaDaSemana();
		for (ProgramaDeTv programa : programas) {
			if (programa.getDiasDaSemana().contains(diaDaSemana)) {
				programasDoDia.add(programa);
			}
		}
		return programasDoDia;
	}
	
	

	/*
	 *  ---------------------------------------------- MÉTODOS UTILITÁRIOS RELACIONADO A ENTENDIDADE PROGRAMA
	 */
	
	public boolean adicionarCanal(Canal canal) {
		if (recuperarCanalPeloNome(canal.getNome()) != null) {
			return false;
		}
		canais.add(canal);
		return true;
	}

	public Canal recuperarCanalPeloNome(String nomeDoCanal) {
		for (Canal canal : canais) {
			if (canal.getNome().equals(nomeDoCanal)) {
				return canal;
			}
		}
		return null;
	}

	public void exibirCanais() {
		System.out.println(canais.toString());
	}

	public void exibirCanaisPeloNome() {
		ArrayList<String> nomeDosCanais = new ArrayList<String>();

		for (Canal canal : canais) {
			nomeDosCanais.add(canal.getNome());
		}
		System.out.print(nomeDosCanais.toString());
	}
}
