package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;


public class OuvinteBotaoEntrar implements ActionListener{
	
	private TelaInicial telaInicial;
	
	
	public OuvinteBotaoEntrar( TelaInicial telaInicial) {
		this.telaInicial = telaInicial;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
   
	public void actionPerformed(ActionEvent e) {
		char[] senhaChar = telaInicial.getTfSenha().getPassword();
		String login = telaInicial.getTfLogin().getText();
		Usuario entrado = new Usuario();
		entrado.setLogin(login);
		
		String	senha = "";
		
		for(int c = 0; senhaChar.length > c; c++) {
			senha += senhaChar[c];
		}
		
		Usuario checkUser = central.validarEntrada(login);  
		
		if(checkUser != null && !checkUser.getLogin().equals(senha) ) {
			new TelaHome(checkUser);
			telaInicial.dispose();
		}else
			JOptionPane.showMessageDialog(telaInicial, "Valor errado ou nada escrito");
	}

}
