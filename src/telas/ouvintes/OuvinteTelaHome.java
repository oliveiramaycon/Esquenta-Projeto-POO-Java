package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import telas.TelaHome;
import telas.canal.TelaListagemCanais;
import telas.programa.TelaListagemProgramas;

public class OuvinteTelaHome implements ActionListener{

	private TelaHome telaHome;
	
	
	
	public OuvinteTelaHome(TelaHome telaHome) {
		super();
		this.telaHome = telaHome;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botao = (JButton) e.getSource();
		
		telaHome.dispose();
		switch(botao.getToolTipText()) {
		
		case "Programas":
			new TelaListagemProgramas(telaHome.getUsuarioLogado());
			break;
			
		case "Canais":
			new TelaListagemCanais(telaHome.getUsuarioLogado());
			break;
		}
		
	}

}
