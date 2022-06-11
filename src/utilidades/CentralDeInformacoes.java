package utilidades;

import java.util.ArrayList;

import excecoes.FalhaNoCadastroException;
import excecoes.RegistroExistenteException;
import excecoes.RegistroNaoEncontradoException;
import excecoes.SemProgramaNaDataAtualException;
import excecoes.TipoDeProgramaNaoExisteException;
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
	 *  ---------------------------------------------- M…TODOS UTILIT¡RIOS RELACIONADO A ENTENDIDADE PROGRAMA
	 */
	
	public void AdicionarProgramaDeTv(ProgramaDeTv programa) throws FalhaNoCadastroException {
		FalhaNoCadastroException falha = new FalhaNoCadastroException();
		
		if (recuperarProgramaDetvPeloId(programa.getId()) != null) {
			String msg = "\nID duplicado!";
			throw new FalhaNoCadastroException(falha.getMessage().concat(msg));
		}

		if (programa.getCanal() == null) {
			String msg = "\n… necess·rio informar um canal";
			throw new FalhaNoCadastroException(falha.getMessage().concat(msg));
		}

		programas.add(programa);
		
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

	public void hasTipoPrograma(TipoPrograma tipoPrograma) throws TipoDeProgramaNaoExisteException {
		
		if(!obterTiposDeProgramas().contains(tipoPrograma.toString())) {
			throw new TipoDeProgramaNaoExisteException();			
		} 
	}
	
	public ArrayList<ProgramaDeTv> obterProgramasComTransmissaoNaDataAtual() throws SemProgramaNaDataAtualException {
		ArrayList<ProgramaDeTv> programasDoDia = new ArrayList<ProgramaDeTv>();
		String diaDaSemana = Datas.obterDiaDaSemana();
		for (ProgramaDeTv programa : programas) {
			
			if (programa.getDiasDaSemana().contains(diaDaSemana)) {
				programasDoDia.add(programa);
			}
		}
		if(programasDoDia.isEmpty()) {
			throw new SemProgramaNaDataAtualException();
		}
		return programasDoDia;
	}
	
	

	/*
	 *  ---------------------------------------------- M…TODOS UTILIT¡RIOS RELACIONADO A ENTENDIDADE PROGRAMA
	 */
	
	public void adicionarCanal(Canal canal) throws RegistroExistenteException {
		try {
			recuperarCanalPeloNome(canal.getNome());
			throw new RegistroExistenteException();
			
		}catch(RegistroNaoEncontradoException e){
			canais.add(canal);
		}
	}

	public Canal recuperarCanalPeloNome(String nomeDoCanal) throws RegistroNaoEncontradoException {
		for (Canal canal : canais) {
			if (canal.getNome().equals(nomeDoCanal)) {
				return canal;
			}
		}
		throw new RegistroNaoEncontradoException();
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
