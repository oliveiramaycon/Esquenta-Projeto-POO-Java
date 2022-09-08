package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.TelaPadrao;

public class OuvinteBotaoVoltarParaHome implements ActionListener {

	private TelaPadrao tela;
	private Usuario usuarioLogado;

	public OuvinteBotaoVoltarParaHome(TelaPadrao tela, Usuario usuarioLogado) {
		super();
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
		new TelaHome(usuarioLogado);
	}

}
