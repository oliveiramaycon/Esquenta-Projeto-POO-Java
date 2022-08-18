package telas.usuario;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import modelo.usuario.Usuario;
import telas.TelaPadrao;
import telas.ouvintes.OuvinteBotaoVoltarParaHome;
import telas.ouvintes.OuvinteDoBotaoMudarDados;
import telas.ouvintes.OuvinteDoCheckBoxEdicaoDados;
import utilidades.CentralDeInformacoes;
import utilidades.Componentes;
import utilidades.Icones;
import utilidades.Imagens;
import utilidades.Medidas;
import utilidades.Persistencia;

public class TelaDeEdicaoDoUsuario extends TelaPadrao {
	private ArrayList<String> opcao;
	private JTextField tfNome;
	private JTextField tfEmail;
	private JTextField tfLogin;
	private JTextField tfSenha;
	private JTextField tfConfirmacaoDeSenha;
	private JCheckBox tfCheckBoxOpcao;
	private JCheckBox tfCheckBoxEmail;
	private JCheckBox tfCheckBoxLogin;
	private JCheckBox tfCheckBoxSenha;
	private JCheckBox tfCheckBoxConfirmarSenha;
	private JLabel lbNome;
	private JLabel lbEmail;
	private JLabel lbLogin;
	private JLabel lbSenha;
	private JLabel lbConfirme;
	private	JButton AlterarDados;
	
	public JButton getAlterarDados() {
		return AlterarDados;
	}
	
	
	public JLabel getLbNome() {
		return lbNome;
	}

	public JLabel getLbEmail() {
		return lbEmail;
	}

	public JLabel getLbLogin() {
		return lbLogin;
	}

	public JLabel getLbSenha() {
		return lbSenha;
	}

	public JLabel getLbConfirme() {
		return lbConfirme;
	}

	public ArrayList<String> getOpcao() {
		return opcao;
	}
	
	public JCheckBox getTfCheckBoxEmail() {
		return tfCheckBoxEmail;
	}

	public JCheckBox getTfCheckBoxLogin() {
		return tfCheckBoxLogin;
	}

	public JCheckBox getTfCheckBoxSenha() {
		return tfCheckBoxSenha;
	}

	public JCheckBox getTfCheckBoxConfirmarSenha() {
		return tfCheckBoxConfirmarSenha;
	}

	public JCheckBox getTfCheckBoxOpcao() {
		return tfCheckBoxOpcao;
	}

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
		this.opcao = new ArrayList<>();

	}

	public void adicionarComponentesGraficos() {
		adicionarBackground();
		addCheckBox();
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

		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", Icones.VOLTAR, 20, 20, Medidas.COMPRIMENTO_50, Medidas.ALTURA_30);
		botaoVoltar.addActionListener(new OuvinteBotaoVoltarParaHome(this, usuarioLogado));

		 AlterarDados = Componentes.addJButton(this, "Salvar", 380, Medidas.FORM_FOOTER, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteDoBotaoMudarDados ouveBotaoPerfio = new OuvinteDoBotaoMudarDados(this);
		AlterarDados.addActionListener(ouveBotaoPerfio);

	}
	private void addCheckBox() {
		
		tfCheckBoxOpcao = Componentes.addCheckBox(this,"nome" ,Medidas.FORM_DEFAULT_X , 440, 70, Medidas.ALTURA_30);
		tfCheckBoxEmail = Componentes.addCheckBox(this,"Email" , 310, 440, 70, Medidas.ALTURA_30);
		tfCheckBoxLogin = Componentes.addCheckBox(this,"Login" , 380, 440, 70, Medidas.ALTURA_30);
		tfCheckBoxSenha = Componentes.addCheckBox(this,"Senha" , 450, 440, 70, Medidas.ALTURA_30); 
		
		OuvinteDoCheckBoxEdicaoDados ouveCheckbox = new OuvinteDoCheckBoxEdicaoDados(this);
		
		tfCheckBoxOpcao.addActionListener(ouveCheckbox);
		tfCheckBoxEmail.addActionListener(ouveCheckbox);
		tfCheckBoxLogin.addActionListener(ouveCheckbox);
		tfCheckBoxSenha.addActionListener(ouveCheckbox);
		
	}

	private void adiconarLabels() {
		Componentes.addJLabel(this, "PERFIL", 405, 30, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
lbNome	=		Componentes.addJLabel(this, "Nome:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_1, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
lbEmail =		Componentes.addJLabel(this, "Email:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_2, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
lbLogin =		Componentes.addJLabel(this, "Login:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_3, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
lbSenha = 		Componentes.addJLabel(this, "Senha:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_4, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
lbConfirme =	Componentes.addJLabel(this, "Confirme a senha:", Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_5, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);

	lbNome.setVisible(false);
	lbEmail.setVisible(false);
	lbLogin.setVisible(false);
	lbSenha.setVisible(false);
	lbConfirme.setVisible(false);
	}

	private void adicionarTextFields() {
		tfNome = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_1+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfEmail = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_2+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfLogin = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_3+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);

		tfSenha = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_4+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		tfConfirmacaoDeSenha = Componentes.addJTextField(this, Medidas.FORM_DEFAULT_X, Medidas.FORM_Y_5+Medidas.FIELD_MARGIN_TOP, Medidas.COMPRIMENTO_400, Medidas.ALTURA_30);
		
		tfNome.setVisible(false);
		tfEmail.setVisible(false);
		tfLogin.setVisible(false);
		tfSenha.setVisible(false);
		tfConfirmacaoDeSenha.setVisible(false);
		
	}
	

}