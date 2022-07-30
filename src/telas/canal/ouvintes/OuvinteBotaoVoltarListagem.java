package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.canal.TelaDetalheCanal;
import telas.canal.TelaListagemCanais;
import telas.canal.TelaNovoCanal;

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

		if (tela instanceof TelaNovoCanal) {
			TelaNovoCanal telaNovoCanal = (TelaNovoCanal) tela;
			if (telaNovoCanal.getCanal() == null) {
				new TelaListagemCanais(usuarioLogado);
			} else {
				new TelaDetalheCanal(usuarioLogado, telaNovoCanal.getCanal());
			}
		} else {
			new TelaListagemCanais(usuarioLogado);
		}
	}

}
