package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import modelo.usuario.exceptions.SenhaCurtaException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import telas.TelaInicial;
import telas.TelaRecuperarSenha;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class OuvinteDoButaoNovaSenha implements ActionListener {

	 TelaRecuperarSenha telaRecuperarS;
	 TelaInicial tela;
	 
	public OuvinteDoButaoNovaSenha(TelaRecuperarSenha telaRecuperarS) {
		this.telaRecuperarS = telaRecuperarS;
		
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	public void mouseClicked(MouseEvent e) {
}	
	public void actionPerformed(ActionEvent e) {
		// METODO PARA NOVA SENHA:
		// SE OS DADOS DO USUARIO NAP FOREM FEITOS NA PROPIA TELA OCORRE UM PROBLEMA NA ARRAY:
		boolean validacaoSenha = false;
		String login = telaRecuperarS.getTfTestarLogin().getText();
				
		String senha = telaRecuperarS.getTfSenha().getText();
		String confirmacaoSenha = telaRecuperarS.getTfConfirmacaoSenha().getText();
		Usuario user = new Usuario();

		try {
			user.validadorDeSenha(senha,confirmacaoSenha);
			validacaoSenha = true;
		} catch (SenhaNaoIgualAConfirmacao| SenhaSemCaracterMaiusculaExecption|SenhaSemMinusculosException|SenhaSemNumerosException|SenhaCurtaException e1)   {
			JOptionPane.showMessageDialog(telaRecuperarS, e1.getMessage());
		}
		if(validacaoSenha == true) {
			central.editarSenha(senha,confirmacaoSenha,login);
			persistencia.salvarCentral(central, "central");
			telaRecuperarS.dispose();
		}
		
	}

}
