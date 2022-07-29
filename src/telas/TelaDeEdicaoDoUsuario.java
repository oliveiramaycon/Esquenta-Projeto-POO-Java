package telas;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteDoBotaoMudarDados;
import utilidades.Componentes;
import utilidades.Imagens;
import utilidades.Medidas;

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
	
	public void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		// background.setBounds(0,0,786, 524);
		setContentPane(background);
	}
	
	private void adicionarBotoes() {
		JButton AlterarDados = Componentes.addJButton(this, "Modificar Dados", 280, 380, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteDoBotaoMudarDados ouveBotaoPerfio = new OuvinteDoBotaoMudarDados(this);
		AlterarDados.addActionListener(ouveBotaoPerfio);
		
	}
	
	private void adiconarLabels() {
		Componentes.addJLabel(this, "PERFIOL", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome:", 220, 63, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Email:", 220, 130, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Login:", 220, 200, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
		Componentes.addJLabel(this, "Senha:", 220, 260, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Confirme a senha:", 220, 320, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
	}

	private void adicionarTextFields() {
		
		tfNome= Componentes.addJTextField(this, 220, 98,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfEmail = Componentes.addJTextField(this, 220, 162,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfLogin  = Componentes.addJTextField(this, 220, 232,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
		tfSenha = Componentes.addJTextField(this, 220, 285,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfConfirmacaoDeSenha = Componentes.addJTextField(this, 220, 345,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

}
