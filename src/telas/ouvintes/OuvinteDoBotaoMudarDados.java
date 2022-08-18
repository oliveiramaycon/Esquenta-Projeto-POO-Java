package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import telas.TelaHome;
import telas.usuario.TelaDeEdicaoDoUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteDoBotaoMudarDados implements ActionListener {

	TelaDeEdicaoDoUsuario telaEditaUsuario;
	
	public OuvinteDoBotaoMudarDados(TelaDeEdicaoDoUsuario telaEditaUsuario) {
		this.telaEditaUsuario = telaEditaUsuario;
	}


	public void actionPerformed(ActionEvent e) {
		
		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		
		
		
		String nome = telaEditaUsuario.getTfNome().getText();
		String email = telaEditaUsuario.getTfEmail().getText();
		String login = telaEditaUsuario.getTfLogin().getText();
		String senha = telaEditaUsuario.getTfSenha().getText();
		String confirmacaoDeSenha = telaEditaUsuario.getTfConfirmacaoDeSenha().getText();
	
		Usuario u = central.editarUsuario(telaEditaUsuario.getOpcao(), nome, email, login, senha, confirmacaoDeSenha);
		
		central.getUsuariosCadastrados().add(u);
		central.getUsuariosCadastrados().remove(0);
		persistencia.salvarCentral(central, "central");
		Componentes.msgSucesso(telaEditaUsuario, "Alterado com Sucesso");
		telaEditaUsuario.dispose();
		new TelaHome(central.getUsuariosCadastrados().get(0));
		
		
		
		
// -----------------------------------------------MODIFICAO DE EDICAO DOS DADOS:
		
	
////--------------------------------EDICAO DE DADOS NA PERSISTENCIA:

}
}
