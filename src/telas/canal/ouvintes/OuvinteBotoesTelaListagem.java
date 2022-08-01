package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.canal.Canal;
import modelo.exceptions.RegistroNaoEncontradoException;
import telas.canal.TelaCanal;
import telas.canal.TelaListagemCanais;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class OuvinteBotoesTelaListagem implements ActionListener {

	private TelaListagemCanais telaListagem;

	public TelaListagemCanais getTelaListagem() {
		return telaListagem;
	}

	public void setTelaListagem(TelaListagemCanais telaListagem) {
		this.telaListagem = telaListagem;
	}

	public OuvinteBotoesTelaListagem(TelaListagemCanais telaListagem) {
		this.telaListagem = telaListagem;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String txtBotao = e.getActionCommand();
		telaListagem.dispose();
		if (txtBotao.equals("Detalhes")) {
			Persistencia persistencia = new Persistencia();
			CentralDeInformacoes central = persistencia.recuperarCentral("central");
			int linhaSelecionada = telaListagem.getTabelaListagem().getSelectedRow();
			long id = (long) telaListagem.getTabelaListagem().getValueAt(linhaSelecionada, 0);
			Canal canalSelecionado = null;
			try {
				canalSelecionado = central.recuperarCanalPeloId(id);
			} catch (RegistroNaoEncontradoException e1) {
				e1.printStackTrace();
			}
			new TelaCanal( telaListagem.getUsuarioLogado(), canalSelecionado, true);
		} else {
			new TelaCanal(telaListagem.getUsuarioLogado());
		}

	}
}
