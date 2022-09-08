package telas.ouvintes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modelo.usuario.Usuario;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Mensageiro;
import utilidades.OutlineJLabel;
import utilidades.Persistencia;

public class OuvinteLabelLink implements MouseListener {

	private TelaInicial tela;
	private OutlineJLabel label;
	private String labelTextFlag;

	public OuvinteLabelLink(TelaInicial tela, OutlineJLabel label) {
		super();
		this.tela = tela;
		this.label = label;
		this.labelTextFlag = label.getText();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");

		Usuario estouValido = central.getUsuariosCadastrados().get(0);

		if (estouValido != null) {
			Mensageiro.enviarSenha(estouValido);
			Componentes.msgSucesso(tela, "Sua senha foi enviada para o seu e-mail!");
			
		} else
			Componentes.msgFalha(tela, "Usuario esta invalido");

		// if(estouValido != null) {
	}
//}	

//			String senha = JOptionPane.showInputDialog("Nova  senha");
//			String ComfirmacaoSenha = JOptionPane.showInputDialog("Confirme a senha ");
//			if(senha.equals(ComfirmacaoSenha)) {
//			central.editarSenha(senha, login);
//			persistencia.salvarCentral(central,"central");
//			}else
//				JOptionPane.showMessageDialog(telaInicial, "Snha e corfimacao dela nao sao iguais");
//		}else
//			JOptionPane.showMessageDialog(telaInicial, "Voce nao esta valido para recuperar a senha!!");
//		

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		tela.setCursor(cursor);
		label.setText("<html><u>" + labelTextFlag + "</u></html>");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
		tela.setCursor(cursor);
		label.setText(labelTextFlag);
	}

}
