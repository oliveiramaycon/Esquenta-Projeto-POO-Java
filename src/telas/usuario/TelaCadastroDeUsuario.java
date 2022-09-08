package telas.usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.TelaPadrao;
import telas.usuario.ouvintes.OuvinteBotaoCadastroDeUsuario;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;

public class TelaCadastroDeUsuario extends TelaPadrao {

	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JTextField tfConfirmacaoDeSenha;

	public JTextField getTfNome() {
		return tfNome;
	}

	public JTextField getTfEmail() {
		return tfEmail;
	}

	public JTextField getTfLogin() {
		return tfLogin;
	}

	public JTextField getTfSenha() {
		return tfSenha;
	}

	public JTextField getTfConfirmacaoDeSenha() {
		return tfConfirmacaoDeSenha;
	}

	public TelaCadastroDeUsuario() {
		super("Cadastro!");
	}

	@Override
	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		setContentPane(background);
	}

	private void adicionarBotoes() {
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 370, Medidas.FORM_FOOTER, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteBotaoCadastroDeUsuario ouvinteCadastrarUsuario = new OuvinteBotaoCadastroDeUsuario(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarUsuario);

	}

	private void adiconarLabels() {
		Componentes.addJLabel(this, "CADASTRO", 385, 25, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_1, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Email:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_2, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Login:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_3, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Senha:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_4, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Confirme a senha:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_5, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_1+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfEmail = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_2+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfLogin = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_3+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);

		tfSenha = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_4+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfConfirmacaoDeSenha = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_5+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
	}

}
