package telas.usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.ouvintes.OuvinteBotaoVoltarParaHome;
import telas.ouvintes.OuvinteDoBotaoMudarDados;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.Persistencia;

public class TelaDeEdicaoDoUsuario extends TelaPadrao {

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

	public TelaDeEdicaoDoUsuario() {
		super("tela de edicao");

	}

	public void adicionarComponentesGraficos() {
		adicionarBackground();
		adicionarTextFields();
		adiconarLabels();
		adicionarBotoes();

	}

	private void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		setContentPane(background);
	}

	private void adicionarBotoes() {

		Persistencia persistencia = new Persistencia();
		CentralDeInformacoes central = persistencia.recuperarCentral("central");
		Usuario usuarioLogado = central.getUsuariosCadastrados().get(0);

		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 20, 20, Medidas.COMPRIMENTO_50,
				Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltarParaHome(this, usuarioLogado));

		JButton AlterarDados = Componentes.addJButton(this, "Salvar", 380, Medidas.FORM_FOOTER, Medidas.COMPRIMENTO_130,
				Medidas.ALTURA_30);
		OuvinteDoBotaoMudarDados ouveBotaoPerfio = new OuvinteDoBotaoMudarDados(this);
		AlterarDados.addActionListener(ouveBotaoPerfio);

	}

	private void adiconarLabels() {
		Componentes.addJLabel(this, "PERFIL", 405, 30, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
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