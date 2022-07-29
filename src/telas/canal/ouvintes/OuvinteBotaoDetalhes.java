package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.canal.Canal;
import modelo.usuario.Usuario;
import telas.canal.TelaDetalheCanal;
import telas.canal.TelaListagemCanais;

public class OuvinteBotaoDetalhes implements ActionListener {
	private TelaDetalheCanal telaDetalhes ; 

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
		new TelaDetalheCanal(telaDetalhes.getUsuarioLogado() , telaDetalhes.getCanal());

	}

}
