package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.exceptions.UsuarioExistenteException;
import modelo.usuario.Usuario;
import modelo.usuario.exceptions.LoginComEspacosException;
import modelo.usuario.exceptions.LoginComMenosCaracterisException;
import modelo.usuario.exceptions.LoginComNumerosException;
import modelo.usuario.exceptions.SenhaCurtaException;
import modelo.usuario.exceptions.SenhaIgualALoginException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import modelo.usuario.exceptions.ValidadorDeEmailExecption;
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
		
	//-----------------------------------------VAI FAZER A VALIDACAO DE USUARIO:
		boolean usuarioEvalido = false;
		
		try {
			usuario.validadorDeLogin(usuario.getLogin());
			usuario.validadorDeSenha(usuario.getSenha(), usuario.getConfirmacaoDeSenha());
			usuario.validadorDeEmail(usuario.getEmail());
			usuarioEvalido = true;
			
		}catch(LoginComEspacosException | LoginComMenosCaracterisException | LoginComNumerosException e1) {
			JOptionPane.showMessageDialog(telaCadastro, e1.getMessage());
		}
		catch(SenhaCurtaException | SenhaSemMinusculosException | SenhaSemCaracterMaiusculaExecption | SenhaSemNumerosException | SenhaNaoIgualAConfirmacao e2 ) {
			JOptionPane.showMessageDialog(telaCadastro, e2.getMessage());
		}
		catch(ValidadorDeEmailExecption e3) {
			JOptionPane.showMessageDialog(telaCadastro, e3.getMessage());
		}
		
		//-----------------------------------------ADICAO DO USUARIO:
		
		
		if(usuarioEvalido == true) {
		try {
			central.adicionarUsuario(usuario);
			//System.out.println("Canal cadastrado com sucesso!\n");
			persistencia.salvarCentral(central, "central");
			Componentes.msgSucesso(telaCadastro, "Usuário cadastrado com sucesso!");
			
			TelaInicial	telaInicia	= new TelaInicial();
			telaInicia.getTfLogin().setText(usuario.getLogin());;
			telaCadastro.dispose();
		} catch (UsuarioExistenteException exception) {
			//System.out.println(exception.getMessage());
			Componentes.msgFalha(telaCadastro, exception.getMessage());
		}
	}
	}

}
