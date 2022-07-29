package main;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.TelaInicial;
import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class ProjetoTelas {
	public static void main(String[] args) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		 //VERIFICA SE TEM USUARIOS NA CENTRAL ANTES DE IR PRA TELA DE LOGIN:
	//if(central.getUsuariosCadastrados().size() > 0) {
		TelaInicial telaInicio = new TelaInicial();
	//}else {
	//TelaCadastroDeUsuario telaCadastroUsuario = new TelaCadastroDeUsuario();
	//}
	//	TelaNovoCanal novoCanal = new TelaNovoCanal();
		TelaHome telaHome = new TelaHome(new Usuario("nome","gato@gmail.com","Ericke","123Eri","123Eri"));
		//TelaListagemProgramas programas = new TelaListagemProgramas();
		//TelaNovoPrograma novoPrograma = new TelaNovoPrograma();
	}

}
