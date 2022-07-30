package telas.usuario;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import telas.TelaPadrao;
import telas.usuario.ouvintes.OuvinteBotaoCadastroDeUsuario;
import utilidades.Componentes;
import utilidades.Icones;
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
	
	public void adicionarBackground() {
		JLabel background = new JLabel(Imagens.BACKGROUND_TELA_CADASTRO);
		setContentPane(background);
	}
	
	private void adicionarBotoes() {
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 390, 470, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteBotaoCadastroDeUsuario ouvinteCadastrarUsuario = new OuvinteBotaoCadastroDeUsuario(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarUsuario);
	
	}
	
	private void adiconarLabels() {
		Componentes.addJLabel(this, "CADASTRO", 390, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Nome:", 320, 150, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Email:", 320, 215, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Login:", 320, 270, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
		Componentes.addJLabel(this, "Senha:", 320, 340, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		Componentes.addJLabel(this, "Confirme a senha:", 320, 405, Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
	}
	
	
	private void adicionarTextFields() {
		
		tfNome= Componentes.addJTextField(this, 320, 180,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfEmail = Componentes.addJTextField(this, 320, 242,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfLogin  = Componentes.addJTextField(this, 320, 302,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		
		tfSenha = Componentes.addJTextField(this, 320, 370,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
		tfConfirmacaoDeSenha = Componentes.addJTextField(this, 320, 430,Medidas.COMPRIMENTO_255, Medidas.ALTURA_30);
	}

	

}
