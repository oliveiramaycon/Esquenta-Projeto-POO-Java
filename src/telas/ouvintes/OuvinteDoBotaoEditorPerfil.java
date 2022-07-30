package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import telas.TelaDeEdicaoDoUsuario;

public class OuvinteDoBotaoEditorPerfil implements ActionListener {

	private JFrame tela;

	public OuvinteDoBotaoEditorPerfil(JFrame tela) {
		super();
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaDeEdicaoDoUsuario();

	}

}
