package main;

import telas.TelaInicial;
import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class main {
	public static void main(String[] args) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		if (central.getUsuariosCadastrados().size() > 0) {
			new TelaInicial();
		} else {
			new TelaCadastroDeUsuario();
		}

	}

}
