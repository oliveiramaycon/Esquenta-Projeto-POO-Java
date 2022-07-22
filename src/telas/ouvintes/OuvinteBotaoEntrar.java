package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

// CRIEI ESTE OUVINTE PARA VALIDACAO DE ENTRADA.
public class OuvinteBotaoEntrar implements ActionListener{
	
	private TelaInicial telaInicial;
	
	public OuvinteBotaoEntrar( TelaInicial telaInicial) {
		this.telaInicial = telaInicial;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
   
	public void actionPerformed(ActionEvent e) {
		
		String login = telaInicial.getTfLogin().getText();
		Usuario entrado = new Usuario();
		entrado.setLogin(login);
		
		Usuario checkUser = central.validarEntrada(login);  
		
		if(checkUser != null ) {
			JOptionPane.showMessageDialog(telaInicial, "Seja bem Vindo" + login);
			new TelaHome();
			telaInicial.dispose();
		}else
			JOptionPane.showMessageDialog(telaInicial, "Valor errado ou nada escrito");
	}

}
