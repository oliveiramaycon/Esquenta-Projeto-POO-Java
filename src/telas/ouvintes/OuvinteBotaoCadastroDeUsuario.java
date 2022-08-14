package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import excecoes.UsuarioExistenteException;
import modelo.Usuario;
import telas.TelaCadastroDeUsuario;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoCadastroDeUsuario implements ActionListener{

	private TelaCadastroDeUsuario telaCadastro;
	
	public OuvinteBotaoCadastroDeUsuario(TelaCadastroDeUsuario telaCadastro) {
		this.telaCadastro = telaCadastro;
	}
	
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		String nome = telaCadastro.getTfNome().getText();
		String email = telaCadastro.getTfEmail().getText();
		String login = telaCadastro.getTfLogin().getText();
		String senha = telaCadastro.getTfSenha().getText();
		String confirmacaoDeSenha = telaCadastro.getTfConfirmacaoDeSenha().getText();
		
		Usuario usuario = new Usuario(nome, email,login, senha, confirmacaoDeSenha);
		
		try {
			central.adicionarUsuario(usuario);
			//System.out.println("Canal cadastrado com sucesso!\n");
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaCadastro, "Usuário cadastrado com sucesso!");
			
			new TelaInicial();
			telaCadastro.dispose();
		} catch (UsuarioExistenteException exception) {
			//System.out.println(exception.getMessage());
			Componentes.msgFalha(telaCadastro, exception.getMessage());
		}
	}
	

}
