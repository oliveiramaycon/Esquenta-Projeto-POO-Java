package telas.canal.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.exceptions.RegistroNaoEncontradoException;
import telas.canal.TelaCanal;
import telas.canal.TelaListagemCanais;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotoesTelaDetalhes implements ActionListener {

	private TelaCanal tela;

	
	public OuvinteBotoesTelaDetalhes(TelaCanal tela) {
		super();
		this.tela = tela;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		String txtBotao = e.getActionCommand();

		
		if (txtBotao.equals("Editar")) {
			new TelaCanal( tela.getUsuarioLogado(), tela.getCanal(), false);
			tela.dispose();
		} else {
			int opcao = Componentes.showConfirmDialog(tela, "Tem certeza?", "Exlusao");
			if (opcao == JOptionPane.YES_OPTION) {

				Persistencia persistencia = new Persistencia();
				CentralDeInformacoes central = persistencia.recuperarCentral("central");
				try {
					central.excluirCanal(tela.getCanal().getId());
					persistencia.salvarCentral(central, "central");
					Componentes.msgSucesso(tela, "Excluido com sucesso!");
					tela.dispose();
					new TelaListagemCanais(tela.getUsuarioLogado());
				} catch (RegistroNaoEncontradoException e1) {

					Componentes.msgFalha(tela, e1.getMessage());
				}
			}
		}

	}

}
