package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.TelaDeEdicaoDoUsuario;
import telas.TelaHome;

public class OuvinteDoBotaoEditorPerfil implements ActionListener {
	TelaHome telaHome;
	
	public OuvinteDoBotaoEditorPerfil(TelaHome telaHome) {
		this.telaHome = telaHome;
	
	}
	
	public void actionPerformed(ActionEvent e) {
		telaHome.dispose();
		new TelaDeEdicaoDoUsuario();
		
	}

}
