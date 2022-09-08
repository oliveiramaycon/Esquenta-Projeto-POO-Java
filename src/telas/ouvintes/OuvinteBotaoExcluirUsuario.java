package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoExcluirUsuario implements ActionListener {

	private JFrame tela;

	public OuvinteBotaoExcluirUsuario(JFrame tela) {
		super();
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Persistencia p = new Persistencia();
		CentralDeInformacoes central = p.recuperarCentral("central");

		central.removerDados(0);
		p.salvarCentral(central, "central");

		Componentes.msgSucesso(tela, "Conta excluida com sucesso!");

		tela.dispose();
		new TelaCadastroDeUsuario();
	}

}
