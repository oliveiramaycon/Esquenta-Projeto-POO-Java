package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.canal.TelaCanal;
import telas.canal.TelaListagemCanais;

public class OuvinteBotaoVoltarListagem implements ActionListener {

	private TelaPadrao tela;
	private Usuario usuarioLogado;

	public OuvinteBotaoVoltarListagem(TelaPadrao tela, Usuario usuarioLogado) {
		this.tela = tela;
		this.usuarioLogado = usuarioLogado;
	}

	public TelaPadrao getTela() {
		return tela;
	}

	public void setTela(TelaPadrao tela) {
		this.tela = tela;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public void actionPerformed(ActionEvent e) {
		tela.dispose();

		if (tela instanceof TelaCanal) {
			TelaCanal telaNovoCanal = (TelaCanal) tela;
			if (telaNovoCanal.getCanal() == null) {
				new TelaListagemCanais(usuarioLogado);
			} else if(telaNovoCanal.isDetalhe()) {
				new TelaListagemCanais(usuarioLogado);				
			}
			else {
				new TelaCanal(usuarioLogado, telaNovoCanal.getCanal(), true);
			}
		} else {
			new TelaListagemCanais(usuarioLogado);
		}
	}

}
