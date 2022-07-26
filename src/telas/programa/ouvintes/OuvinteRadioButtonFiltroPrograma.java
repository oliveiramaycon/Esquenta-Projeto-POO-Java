package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.programa.TelaNovoPrograma;

public class OuvinteRadioButtonFiltroPrograma implements ActionListener {
	
	private TelaNovoPrograma tela;
	
	public OuvinteRadioButtonFiltroPrograma(TelaNovoPrograma tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		String radioSelecionado = e.getActionCommand();
		
		
		switch (radioSelecionado) {
		
		case "Series Regulares":
			tela.getTfApresentadores().setVisible(false);
			tela.getApresentadores().setVisible(false);
			tela.getGeneros().setVisible(true);
			tela.getEstilo().setVisible(true);
			tela.getGenero().setVisible(true);
			tela.getEstilos().setVisible(true);
			break;
		default:
			tela.getGenero().setVisible(false);
			tela.getEstilo().setVisible(false);
			tela.getGeneros().setVisible(false);
			tela.getEstilos().setVisible(false);
			tela.getTfApresentadores().setVisible(true);
			tela.getApresentadores().setVisible(true);
			break;
		}
	}

}
