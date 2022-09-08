package telas.programa.ouvintes;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import telas.programa.TelaNovoPrograma;

public class OuvinteFocoApresentadores implements FocusListener {
	TelaNovoPrograma tela;

	public OuvinteFocoApresentadores(TelaNovoPrograma tela) {
		this.tela = tela;
	}

	public void focusGained(FocusEvent e) {
		JTextField jt = (JTextField) e.getSource();
		String exemplo = tela.getTfApresentadores().getText();
		if (exemplo.equals("Exmplo: Jorge, Larissa")) {
			tela.getTfApresentadores().setText("");
			tela.getTfApresentadores().repaint();
		}
	}

	public void focusLost(FocusEvent e) {
		JTextField jt = (JTextField) e.getSource();
		String exemplo = tela.getTfApresentadores().getText();
		boolean validacao = exemplo.trim().equals("");
		if (validacao) {
			tela.getTfApresentadores().setText("Exmplo: Jorge, Larissa");
			tela.getTfApresentadores().repaint();
		}

	}
}
