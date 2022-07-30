package telas.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import modelo.usuario.Usuario;
import modelo.usuario.exceptions.LoginComEspacosException;
import modelo.usuario.exceptions.LoginComMenosCaracterisException;
import modelo.usuario.exceptions.LoginComNumerosException;
import modelo.usuario.exceptions.SenhaCurtaException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import modelo.usuario.exceptions.ValidadorDeEmailExecption;
import telas.TelaDeEdicaoDoUsuario;
import telas.TelaInicial;
import utilidades.CentralDeInformacoes;
import utilidades.Persistencia;

public class OuvinteDoBotaoMudarDados implements ActionListener{

	TelaDeEdicaoDoUsuario telaEditaUsuario;
	
	
	public OuvinteDoBotaoMudarDados(TelaDeEdicaoDoUsuario telaEditaUsuario) {
		this.telaEditaUsuario = telaEditaUsuario;
	}
	
	Persistencia persistencia = new Persistencia();
	CentralDeInformacoes central = persistencia.recuperarCentral("central");
	
	public void actionPerformed(ActionEvent e) {
		String nome = telaEditaUsuario.getTfNome().getText();
		String email = telaEditaUsuario.getTfEmail().getText();
		String login = telaEditaUsuario.getTfLogin().getText();
		String senha = telaEditaUsuario.getTfSenha().getText();
		String confirmacaoDeSenha = telaEditaUsuario.getTfConfirmacaoDeSenha().getText();
		
		Usuario usuario = new Usuario(nome, email, login, senha, confirmacaoDeSenha);
		//-----------------------------------------------MODIFICAO DE EDICAO DOS DADOS:
		boolean loginValido = false;
		boolean senhaValida = false;
		boolean validarEmail = false;
		
	try {
		usuario.validadorDeLogin(login);
		loginValido = true;
	}
	catch (LoginComEspacosException| LoginComMenosCaracterisException|LoginComNumerosException e2) {
		JOptionPane.showMessageDialog(telaEditaUsuario, e2.getMessage());
		}
 if(loginValido != true && validarEmail != true) {
	try {
		usuario.validadorDeSenha(senha, confirmacaoDeSenha);
		senhaValida = true;
		}
		catch(SenhaCurtaException | SenhaSemMinusculosException | SenhaSemCaracterMaiusculaExecption | SenhaSemNumerosException | SenhaNaoIgualAConfirmacao e2 ) {
			JOptionPane.showMessageDialog(telaEditaUsuario, e2.getMessage());
		}
 	}
if(senhaValida != true && loginValido != true) {	
	try {			
			usuario.validadorDeEmail(email);
			validarEmail = true;
		}
	catch(ValidadorDeEmailExecption e2 ) {
			JOptionPane.showMessageDialog(telaEditaUsuario, e2.getMessage());	
		}
}
//--------------------------------EDICAO DE DADOS NA PERSISTENCIA:
		if(loginValido = true && !login.isEmpty() && !nome.isEmpty()) {
			central.editarUsuario(0, login, nome);
			persistencia.salvarCentral(central, "central");
			JOptionPane.showMessageDialog(telaEditaUsuario, "Login e Nome editado com sucesso");
			telaEditaUsuario.dispose();
			new TelaInicial();
		}
		if(senhaValida = true && !senha.isEmpty() && !confirmacaoDeSenha.isEmpty() ) {
			central.editarUsuario(0, senha, confirmacaoDeSenha, null);
			persistencia.salvarCentral(central, "central");
			JOptionPane.showMessageDialog(telaEditaUsuario, "Senha e confirmcao de senha editados com sucesso");
			telaEditaUsuario.dispose();
			new TelaInicial();
		}
		if(validarEmail = true && !email.isEmpty() ) {
			central.editarUsuario(0, email);
			persistencia.salvarCentral(central, "central");
			JOptionPane.showMessageDialog(telaEditaUsuario, "Email editados com sucesso");
			telaEditaUsuario.dispose();
			new TelaInicial();
		}
			
		}
}
