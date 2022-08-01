package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.canal.TelaCanal;
import telas.canal.TelaListagemCanais;

public class OuvinteBotaoDetalhes implements ActionListener {
	private TelaCanal tela;

	private TelaListagemCanais TelaListagemCanais;

	public OuvinteBotaoDetalhes(TelaListagemCanais TelaListagemCanais) {
		this.TelaListagemCanais = TelaListagemCanais;
	}

	public TelaListagemCanais getTelaListagemCanais() {
		return TelaListagemCanais;
	}

	public void setTelaListagemCanais(TelaListagemCanais telaListagemCanais) {
		TelaListagemCanais = telaListagemCanais;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TelaListagemCanais.dispose();
		new TelaCanal(tela.getUsuarioLogado(), tela.getCanal(), true);

	}

}
