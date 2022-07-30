package telas.programa.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.programa.enums.Status;
import telas.programa.TelaNovoPrograma;

public class OuvinteComboBoxHiato implements ActionListener {
	TelaNovoPrograma tela;

	public OuvinteComboBoxHiato(TelaNovoPrograma tela) {
		this.tela = tela;
	}

	public void actionPerformed(ActionEvent e) {
		Status status = (Status.valueOf((String) tela.getStatus().getSelectedItem()));
		if (status == Status.HIATO) {
			tela.getData().setVisible(true);
			tela.getDataRetorno().setVisible(true);
		} else {
			tela.getData().setVisible(false);
			tela.getDataRetorno().setVisible(false);
		}

	}

}
