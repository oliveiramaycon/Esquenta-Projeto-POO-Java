package main;

import modelo.usuario.Usuario;
import telas.TelaListagemCanais;

public class Main {
public static void main(String[] args) {
		
		//TelaInicial telaInicio = new TelaInicial();
		//TelaCadastroDeUsuario telaCadastroUsuario = new TelaCadastroDeUsuario();
		//TelaNovoCanal novoCanal = new TelaNovoCanal(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
		//TelaHome telaHome = new TelaHome();
		//TelaListagemProgramas programas = new TelaListagemProgramas();
		//TelaNovoPrograma novoPrograma = new TelaNovoPrograma();
		TelaListagemCanais listagemCanais = new TelaListagemCanais(new Usuario("manco", "manco@gmail.com", "manco", "Mancones1", "Mancones1"));
		//TelaDetalheCanal teladetalhesCanal = new TelaDetalheCanal();
	}
}
