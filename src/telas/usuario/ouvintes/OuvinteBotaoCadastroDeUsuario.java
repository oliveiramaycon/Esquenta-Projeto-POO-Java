package telas.usuario.ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.exceptions.UsuarioExistenteException;
import modelo.usuario.Usuario;
import modelo.usuario.ValidadorUsuario;
import modelo.usuario.exceptions.LoginComEspacosException;
import modelo.usuario.exceptions.SenhaNaoIgualAConfirmacao;
import modelo.usuario.exceptions.SenhaSemCaracterMaiusculaExecption;
import modelo.usuario.exceptions.SenhaSemMinusculosException;
import modelo.usuario.exceptions.SenhaSemNumerosException;
import modelo.usuario.exceptions.StringComMenosCarecterisExecption;
import modelo.usuario.exceptions.ValidadorDeEmailExecption;
import telas.TelaInicial;
import telas.usuario.TelaCadastroDeUsuario;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Persistencia;

public class OuvinteBotaoCadastroDeUsuario implements ActionListener {

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

		Usuario usuario = new Usuario(nome, email, login, senha, confirmacaoDeSenha);

		// -----------------------------------------VAI FAZER A VALIDACAO DE USUARIO:
		boolean usuarioEvalido = false;

		try {
			ValidadorUsuario.validadorDeLogin(usuario.getLogin());
			ValidadorUsuario.validadorDeSenha(usuario.getSenha(), usuario.getConfirmacaoDeSenha());
			ValidadorUsuario.verificaEmail(usuario.getEmail());
			usuarioEvalido = true;

		} catch (LoginComEspacosException | StringComMenosCarecterisExecption 
		 |  SenhaSemMinusculosException | SenhaSemCaracterMaiusculaExecption
		 | SenhaSemNumerosException | SenhaNaoIgualAConfirmacao 
		 |ValidadorDeEmailExecption e1) {
			Componentes.msgSucesso(telaCadastro, e1.getMessage());
		}

		// -----------------------------------------ADICAO DO USUARIO:

		if (usuarioEvalido == true) {
			try {
				central.adicionarUsuario(usuario);
				persistencia.salvarCentral(central, "central");
				Componentes.msgSucesso(telaCadastro, "Usuario cadastrado com sucesso!");

				TelaInicial telaInicia = new TelaInicial();
				telaInicia.getTfLogin().setText(usuario.getLogin());
				;
				telaCadastro.dispose();
			} catch (UsuarioExistenteException exception) {
				Componentes.msgFalha(telaCadastro, exception.getMessage());
			}
		}
	}

}
