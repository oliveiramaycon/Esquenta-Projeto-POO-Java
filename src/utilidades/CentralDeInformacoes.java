package utilidades;

import java.time.DayOfWeek;
import java.util.ArrayList;

import modelo.canal.Canal;
import modelo.canal.enums.TipoCanal;
import modelo.exceptions.FalhaNoCadastroException;
import modelo.exceptions.RegistroExistenteException;
import modelo.exceptions.RegistroNaoEncontradoException;
import modelo.exceptions.UsuarioExistenteException;
import modelo.programa.ProgramaDeTv;
import modelo.programa.enums.Estilo;
import modelo.programa.enums.Genero;
import modelo.programa.enums.Status;
import modelo.programa.enums.TipoPrograma;
import modelo.programa.exceptions.ProgramaJaAdicionado;
import modelo.programa.exceptions.SemProgramaNaDataAtualException;
import modelo.programa.exceptions.TipoDeProgramaNaoExisteException;
import modelo.usuario.Usuario;

public class CentralDeInformacoes {

	private ArrayList<ProgramaDeTv> programas = new ArrayList<ProgramaDeTv>();
	private ArrayList<Canal> canais = new ArrayList<Canal>();
	private ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();

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

	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}

	public void setUsuariosCadastrados(ArrayList<Usuario> usuariosCadastrados) {
		this.usuariosCadastrados = usuariosCadastrados;
	}

	/*
	 * ---------------------------------------------- M�TODOS UTILIT�RIOS
	 * RELACIONADO A ENTENDIDADE PROGRAMA
	 */

	public void AdicionarProgramaDeTv(ProgramaDeTv programa) throws FalhaNoCadastroException {
		FalhaNoCadastroException falha = new FalhaNoCadastroException();

		if (recuperarProgramaDetvPeloId(programa.getId()) != null) {
			String msg = "\nID duplicado!";
			throw new FalhaNoCadastroException(falha.getMessage().concat(msg));
		}

		if (programa.getCanal() == null) {
			String msg = "\n� necess�rio informar um canal";
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
	public boolean buscarProgramaPeloNome(String buscar) throws ProgramaJaAdicionado {
		for(ProgramaDeTv programa : programas) {
			if(programa.getNome().equals(buscar)) {
				throw new ProgramaJaAdicionado();
			}
		}
		return false;
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
	public ArrayList<String> obterCanaisNome(){
		ArrayList<String> nomes = new ArrayList<>();
		for(Canal canal: getCanais()){
			nomes.add(canal.toString());
		}
		return nomes;
	}
	public ArrayList<String> obterTiposDeStatus() {
		ArrayList<String> tipos = new ArrayList<>();
		for (Status status : Status.values())
			tipos.add(status.toString());
		return tipos;

	}

	public ArrayList<String> obterGeneroDePrograma() {
		ArrayList<String> generos = new ArrayList<>();
		for (Genero genero : Genero.values())
			generos.add(genero.toString());
		return generos;
	}

	public ArrayList<String> obterEstilosDePrograma() {
		ArrayList<String> estilos = new ArrayList<>();
		for (Estilo genero : Estilo.values())
			estilos.add(genero.toString());
		return estilos;
	}

	public ArrayList<String> obterTiposDeProgramas() {
		ArrayList<String> tipos = new ArrayList<String>();
		for (TipoPrograma tipo : TipoPrograma.values()) {
			tipos.add(tipo.toString());
		}

		return tipos;
	}

	public void hasTipoPrograma(TipoPrograma tipoPrograma) throws TipoDeProgramaNaoExisteException {

		if (!obterTiposDeProgramas().contains(tipoPrograma.toString())) {
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
		if (programasDoDia.isEmpty()) {
			throw new SemProgramaNaDataAtualException();
		}
		return programasDoDia;
	}

	/*
	 * ---------------------------------------------- M�TODOS UTILIT�RIOS
	 * RELACIONADO A ENTENDIDADE CANAL
	 */

	public void adicionarCanal(Canal canal) throws RegistroExistenteException {
		try {
			recuperarCanalPeloNome(canal.getNome());
			throw new RegistroExistenteException();

		} catch (RegistroNaoEncontradoException e) {
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

	public Canal recuperarCanalPeloId(long id) throws RegistroNaoEncontradoException {
		for (Canal canal : canais) {
			if (canal.getId() == id) {
				return canal;
			}
		}
		throw new RegistroNaoEncontradoException();
	}

	public Canal excluirCanal(long id) throws RegistroNaoEncontradoException {
		Canal canalRecuperado = recuperarCanalPeloId(id);
		canais.remove(canalRecuperado);
		return canalRecuperado;
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

	public ArrayList<String> obterTiposDeCanaisTelevisivos() {
		ArrayList<String> tipos = new ArrayList<String>();
		for (TipoCanal tipo : TipoCanal.values()) {
			if (tipo.toString().endsWith("TELEVISAO")) {
				tipos.add(tipo.toString());
			}
		}

		return tipos;
	}

	public ArrayList<String> obterTiposDeCanais() {
		ArrayList<String> tipos = new ArrayList<String>();
		tipos.add("");
		for (TipoCanal tipo : TipoCanal.values()) {
			tipos.add(tipo.toString());
		}
		return tipos;
	}

	public ArrayList<String> obterTiposDeCanaisBroadcasting() {
		ArrayList<String> tipos = new ArrayList<String>();
		for (TipoCanal tipo : TipoCanal.values()) {
			if (tipo.toString().endsWith("BROADCASTING")) {
				tipos.add(tipo.toString());
			}
		}

		return tipos;
	}

	/*
	 * ---------------------------------------ENTIDADE DO USUARIO ENTRADA E REMOCAO
	 * DE DADOS:
	 */

	// CRIEI PARA A VERIFICACAO DE USUARIO NA ARRY
	public Usuario validarEntrada(String login) {
		Usuario novo = null;
		for (Usuario u : usuariosCadastrados) {
			if (u.getLogin().equals(login)) {
				novo = u;
			}
		}
		return novo;
	}

	public Usuario buscarDados(int buscador) {
		return	usuariosCadastrados.get(buscador);
			
		}
		
		// METODO SO SERVE PRA MODIFICAR A SENHA DO USUARIO:
		public void editarUsuario(int buscador, String novoLogin, String novoNome ) {
			Usuario	 editor =	buscarDados(buscador);
			editor.setLogin(novoLogin);  editor.setNome(novoNome);
		}
		public void  editarUsuario(int buscador, String novaSenha , String novaConfirmacao, String nadaFeito){
			Usuario editor = buscarDados(buscador);
		 	editor.setSenha(novaSenha); editor.setConfirmacaoDeSenha(novaConfirmacao);
		}
		public void editarUsuario(int buscador, String novoEmail){
			Usuario editor = buscarDados(buscador);
			editor.setEmail(novoEmail);	
		}
		//REMOCAO DO USUARIO:
		public Usuario removerDados(int remover) {
			Usuario novo =  buscarDados(remover);
			usuariosCadastrados.remove(novo);
			return novo;
		}


	public void adicionarUsuario(Usuario usuario) throws UsuarioExistenteException {
		for (Usuario u : usuariosCadastrados) {
			if (u.getLogin().equals(usuario.getLogin()) && u.getSenha().equals(usuario.getSenha())) {
				throw new UsuarioExistenteException();
			}
		}
		usuariosCadastrados.add(usuario);
	}

	public ArrayList<String> mudarDiaDaSemana(ArrayList<DayOfWeek> dia){
		ArrayList<String> diasPtBr = new ArrayList<>();
		if(dia.contains(DayOfWeek.MONDAY))
			diasPtBr.add("Segunda-Feira");
		if(dia.contains(DayOfWeek.TUESDAY))
			diasPtBr.add("Terca-Feira");
		if(dia.contains(DayOfWeek.WEDNESDAY))
			diasPtBr.add("Quarta-Feira");
		if(dia.contains(DayOfWeek.THURSDAY))
			diasPtBr.add("Quinta-Feira");
		if(dia.contains(DayOfWeek.FRIDAY))
			diasPtBr.add("Sexta-Feira");
		if(dia.contains(DayOfWeek.SATURDAY))
			diasPtBr.add("Sabado");
		if(dia.contains(DayOfWeek.SUNDAY))
			diasPtBr.add("Domingo");
		return diasPtBr;
	}
	
}
