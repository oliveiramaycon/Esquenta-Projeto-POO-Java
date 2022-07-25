package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import telas.TelaDetalhePrograma;
import telas.TelaListagemProgramas;

public class OuvinteBotaoDetalhesPrograma implements ActionListener{
	
	private TelaListagemProgramas tela;
	
	public OuvinteBotaoDetalhesPrograma(TelaListagemProgramas tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		tela.dispose();
		new TelaDetalhePrograma();
	}

}
