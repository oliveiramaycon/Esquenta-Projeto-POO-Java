package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.programa.TelaNovoPrograma;

public class OuvinteRadioButtonPrograma implements ActionListener {
	
	private TelaNovoPrograma tela;
	
	public OuvinteRadioButtonPrograma(TelaNovoPrograma tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		String radioSelecionado = e.getActionCommand();
		switch (radioSelecionado) {
		case "Series Regulares":
			break;

		default:
			break;
		}
	}

}
