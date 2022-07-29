package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import telas.TelaHome;
import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class OuvintBotoesTelaInicial implements ActionListener {

	private JFrame tela;

	public OuvintBotoesTelaInicial(JFrame tela) {
		this.tela = tela;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		case "Entrar":
			// TODO: realizar validação
//			new TelaHome();
			tela.dispose();
			break;
		case "Cadastre-se":
			
			new TelaCadastroDeUsuario();
			tela.dispose();
			break;
		case "Esqueceu a senha?":
			//TODO: fazer tela
			break;
		case "Catálogo":
			//TODO: fazer tela
			break;
		}

	}

}
