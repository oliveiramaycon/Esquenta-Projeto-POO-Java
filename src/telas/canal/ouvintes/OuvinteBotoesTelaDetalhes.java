package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.exceptions.RegistroNaoEncontradoException;
import telas.canal.TelaDetalheCanal;
import telas.canal.TelaListagemCanais;
import telas.canal.TelaNovoCanal;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotoesTelaDetalhes implements ActionListener {

	private TelaDetalheCanal telaDetalheCanal;

	public OuvinteBotoesTelaDetalhes(TelaDetalheCanal telaDetalheCanal) {
		this.telaDetalheCanal = telaDetalheCanal;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String txtBotao = e.getActionCommand();

		telaDetalheCanal.dispose();
		if (txtBotao.equals("Editar")) {
			new TelaNovoCanal(telaDetalheCanal.getCanal(), telaDetalheCanal.getUsuarioLogado());

		} else {
			int opcao = Componentes.showConfirmDialog(telaDetalheCanal, "Tem certeza?", "Exlusao");
			if (opcao == JOptionPane.YES_OPTION) {

				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral("central");
				try {
					central.excluirCanal(telaDetalheCanal.getCanal().getId());
					persistencia.salvarCentral(central, "central");
					Componentes.msgSucesso(telaDetalheCanal, "Excluido com sucesso!");
					new TelaListagemCanais(telaDetalheCanal.getUsuarioLogado());
				} catch (RegistroNaoEncontradoException e1) {

					Componentes.msgFalha(telaDetalheCanal, e1.getMessage());
				}
			}
		}

	}

}
