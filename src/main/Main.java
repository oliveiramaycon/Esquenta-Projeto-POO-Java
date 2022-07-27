package main;


import modelo.programa.ProgramaDeTv;
import modelo.usuario.Usuario;
import telas.canal.TelaListagemCanais;
import telas.programa.TelaDetalhePrograma;
import telas.programa.TelaListagemProgramas;
import telas.programa.TelaNovoPrograma;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;


public class Main {
public static void main(String[] args) {
		
//		TelaInicial telaInicio = new TelaInicial();
//		TelaCadastroDeUsuario telaCadastroUsuario = new TelaCadastroDeUsuario();
//		TelaNovoCanal novoCanal = new TelaNovoCanal(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
//		TelaHome telaHome = new TelaHome();

		TelaListagemProgramas programas = new TelaListagemProgramas(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
//		TelaNovoPrograma novoPrograma = new TelaNovoPrograma(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
//		TelaListagemCanais listagemCanais = new TelaListagemCanais(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
//		TelaDetalheCanal teladetalhesCanal = new TelaDetalheCanal();
//		TelaDetalhePrograma telaDetalhePrograma = new TelaDetalhePrograma();
	}
}
