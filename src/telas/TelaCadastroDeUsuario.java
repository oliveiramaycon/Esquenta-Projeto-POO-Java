package telas;

import javax.swing.JButton;
import javax.swing.JTextField;

import telas.ouvintes.OuvinteBotaoCadastroDeUsuario;
import utilidades.Componentes;
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
		adicionarBotoes();
		adiconarLabels();
		adicionarTextFields();
	}
	
	private void adicionarBotoes() {
		JButton botaoVoltar = Componentes.addJButton(this, "Voltar", 20, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		//TODO: ouvinte voltar
		JButton botaoCadastrar = Componentes.addJButton(this, "Cadastrar", 280, 380, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
		OuvinteBotaoCadastroDeUsuario ouvinteCadastrarUsuario = new OuvinteBotaoCadastroDeUsuario(this);
		botaoCadastrar.addActionListener(ouvinteCadastrarUsuario);
	
	}
	
	private void adiconarLabels() {
		Componentes.addJLabel(this, "CADASTRO", 318, 20, Medidas.COMPRIMENTO_130, Medidas.ALTURA_30);
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
