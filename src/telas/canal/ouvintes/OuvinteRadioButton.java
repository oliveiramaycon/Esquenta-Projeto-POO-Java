package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.canal.TelaCanal;

public class OuvinteRadioButton implements ActionListener {

	private TelaCanal tela;

	public TelaCanal getTela() {
		return tela;
	}

	public void setTela(TelaCanal tela) {
		this.tela = tela;
	}

	public OuvinteRadioButton(TelaCanal tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String radioSelecionado = e.getActionCommand();

		switch (radioSelecionado) {
		case "Broadcasting":
			tela.getCbTv().setVisible(false);
			tela.getCbBroadcasting().setVisible(true);
			tela.getNumeroCanal().setVisible(false);
			tela.getLinkBroadcasting().setVisible(true);
			break;
		case "Televisao":
			tela.getCbTv().setVisible(true);
			tela.getCbBroadcasting().setVisible(false);
			tela.getNumeroCanal().setVisible(true);
			tela.getLinkBroadcasting().setVisible(false);
			break;
		}

	}

}
