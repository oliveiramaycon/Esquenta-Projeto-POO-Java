package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import telas.usuario.TelaCadastroDeUsuario;
import telas.usuario.TelaDeEdicaoDoUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteMenu implements ActionListener {
	private JFrame tela;

	public OuvinteMenu(JFrame tela) {
		super();
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String opcao = e.getActionCommand();

		switch (opcao) {

		case "Sair":
			int confirmacaoSair = Componentes.showConfirmDialog(tela, "Tem certeza?", "sair");
			if (confirmacaoSair == JOptionPane.YES_OPTION) {
				tela.dispose();
			}
			break;

		case "Excluir Conta":
			int confirmacaoExcluir = Componentes.showConfirmDialog(tela, "Tem certeza?", "Exlusao");
			if (confirmacaoExcluir == JOptionPane.YES_OPTION) {

				Persistencia p = new Persistencia();
				CentralDeInformacoes central = p.recuperarCentral("central");

				central.removerDados(0);
				p.salvarCentral(central, "central");

				tela.dispose();
				new TelaCadastroDeUsuario();
			}
			break;

		case "Editar Perfil":
			tela.dispose();
			new TelaDeEdicaoDoUsuario();
			break;
		}

	}

}
