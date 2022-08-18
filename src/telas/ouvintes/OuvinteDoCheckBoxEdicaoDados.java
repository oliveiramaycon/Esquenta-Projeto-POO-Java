package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import telas.usuario.TelaDeEdicaoDoUsuario;

public class OuvinteDoCheckBoxEdicaoDados implements ActionListener {
	TelaDeEdicaoDoUsuario telaEdicao;

	public OuvinteDoCheckBoxEdicaoDados(TelaDeEdicaoDoUsuario telaEdicao) {
		this.telaEdicao = telaEdicao;
	}

	 

	public void actionPerformed(ActionEvent e) {
		
		ArrayList<String> options = telaEdicao.getOpcao();
		
		
		if(telaEdicao.getTfCheckBoxOpcao().isSelected()) {
			options.add("1");
			telaEdicao.getTfNome().setVisible(true);
			telaEdicao.getLbNome().setVisible(true);
		}else {
			if(options.contains("1")) {
				options.remove("1");
			}
			telaEdicao.getTfNome().setVisible(false);
			telaEdicao.getLbNome().setVisible(false);
		}
		
		if(telaEdicao.getTfCheckBoxEmail().isSelected()) {
			options.add("2");
			
			telaEdicao.getTfEmail().setVisible(true);
			telaEdicao.getLbEmail().setVisible(true);

		}else {
			if(options.contains("2")) {
				options.remove("2");
			}
			telaEdicao.getTfEmail().setVisible(false);
			telaEdicao.getLbEmail().setVisible(false);
		}
		
		if(telaEdicao.getTfCheckBoxLogin().isSelected()) {
			options.add("3");

			telaEdicao.getTfLogin().setVisible(true);
			telaEdicao.getLbLogin().setVisible(true);

		}else {
			if(options.contains("3")) {
				options.remove("3");
			}
			telaEdicao.getTfLogin().setVisible(false);
			telaEdicao.getLbLogin().setVisible(false);

		}
		
		if(telaEdicao.getTfCheckBoxSenha().isSelected()) {
			options.add("4");

			telaEdicao.getTfSenha().setVisible(true);
			telaEdicao.getLbSenha().setVisible(true);
			telaEdicao.getTfConfirmacaoDeSenha().setVisible(true);
			telaEdicao.getLbConfirme().setVisible(true);

		}else {
			if(options.contains("4")) {
				options.remove("4");
			}
			telaEdicao.getTfSenha().setVisible(false);
			telaEdicao.getLbSenha().setVisible(false);
			telaEdicao.getTfConfirmacaoDeSenha().setVisible(false);
			telaEdicao.getLbConfirme().setVisible(false);

		}

	}
}
